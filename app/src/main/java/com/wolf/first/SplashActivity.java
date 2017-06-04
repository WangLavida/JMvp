package com.wolf.first;

import android.os.Bundle;
import android.view.View;

import com.dinuscxj.progressbar.CircleProgressBar;
import com.wolf.first.base.BaseActivity;
import com.wolf.first.base.BaseBean;
import com.wolf.first.bean.CategoryBean;
import com.wolf.first.ui.MenuActivity;
import com.wolf.first.ui.contract.SplashContract;
import com.wolf.first.ui.model.SplashModel;
import com.wolf.first.ui.presenter.SplashPresenter;
import com.wolf.first.util.AppUtil;

import butterknife.Bind;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends BaseActivity<SplashPresenter, SplashModel> implements
        SplashContract.View {


    @Bind(R.id.line_progress)
    CircleProgressBar lineProgress;
    private Integer proMax = 5;
    private BaseBean<CategoryBean> baseBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        lineProgress.setClickable(false);
        lineProgress.setProgress(100);
        lineProgress.setProgressTextFormatPattern(proMax+"");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                while (proMax >= 0) {
                    try {
                        Thread.sleep(1000);
                        e.onNext(proMax);
                        proMax--;
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io()).compose(this.<Integer>bindToLifecycle()).observeOn
                (AndroidSchedulers.mainThread()).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                lineProgress.setProgress(proMax * 20);
                if (proMax == 0) {
                    toMenu();
                } else {
                    if (baseBean != null) {
                        lineProgress.setProgressTextFormatPattern("跳过" + proMax);
                    } else {
                        lineProgress.setProgressTextFormatPattern(proMax + "");
                    }
                }
            }
        });
        lineProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMenu();
            }
        });
    }

    @Override
    public void initData() {
        mPresenter.getCategory();
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    private void toMenu() {
        MenuActivity.startTest(SplashActivity.this,baseBean);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppUtil.setFull(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        this.baseBean = baseBean;
        lineProgress.setClickable(true);
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onError(String msg) {

    }
}

package com.wolf.first.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by W.J on 2017/5/23.
 */

public class TestBean implements Serializable{

    /**
     * size : 10
     * list : [{"imgurl":"http://dingyue.nosdn.127.net/1vXUfazxJswOkuWkurqx3HYQh6VJTYBjXfKibXhXeUJ1z1495359006800transferflag.png","has_content":true,"docurl":"http://war.163.com/17/0523/10/CL46SK9G0001879A.html","id":4949,"time":"2017-05-23 10:34:46","title":"歼31与F35＂厮杀＂ 能胜？军迷表示一技术无人能敌","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/1/1f/1f730937e886c8bc555d09103908e396.jpg","has_content":true,"docurl":"http://war.163.com/17/0523/10/CL46PEQK000181KT.html","id":4950,"time":"2017-05-23 10:33:02","title":"韩防长视察朝鲜战争遗址 慰问发掘军人遗骸官兵","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/e/e9/e9b7c4b05e851ebfcb1a700b7b75f071.jpeg","has_content":true,"docurl":"http://war.163.com/17/0523/10/CL46GV1P000181KT.html","id":4951,"time":"2017-05-23 10:28:23","title":"韩媒： 韩国新政府须尽早摆脱\u201c萨德神化\u201d","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/8/83/834503c341f2c4ecf18649acfb2a4333.jpg","has_content":true,"docurl":"http://war.163.com/17/0523/10/CL460O20000181KT.html","id":4934,"time":"2017-05-23 10:19:32","title":"英首相：全力调查疑似恐袭 心系遇难者及家属","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/8/83/834503c341f2c4ecf18649acfb2a4333.jpg","has_content":true,"docurl":"http://war.163.com/17/0523/10/CL45S8BM000181KT.html","id":4935,"time":"2017-05-23 10:17:05","title":"英国官员：体育场爆炸疑为自杀式炸弹袭击","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/3/3a/3a291bc82e52001bedc3248dc635aecc.jpg","has_content":true,"docurl":"http://war.163.com/17/0523/10/CL45J9V6000181KT.html","id":4933,"time":"2017-05-23 10:12:12","title":"美媒设想对朝作战\u201c全景图\u201d：整个半岛将被摧毁","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/1/17/17376818585734df500e1745d73533a8.jpg","has_content":true,"docurl":"http://war.163.com/17/0523/10/CL45CB9T000181KT.html","id":4932,"time":"2017-05-23 10:08:24","title":"让子弹飞3秒 英狙击手2.4公里外击毙恐怖分子","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/a/ab/ab78e6f89078a71a5ca30cee2022c0f4.jpg","has_content":true,"docurl":"http://war.163.com/17/0523/10/CL455TQV000181KT.html","id":4913,"time":"2017-05-23 10:04:53","title":"释放完整战力 美军年内接收\u201c完整版\u201dF-35战机","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/3/3f/3fec2b3ba39e918facf8fd7ad26001ba.jpg","has_content":true,"docurl":"http://war.163.com/17/0523/10/CL44TT2D000181KT.html","id":4914,"time":"2017-05-23 10:00:30","title":"日本极右翼分子田母神俊雄违法被判刑","channelname":"war"},{"imgurl":"http://cms-bucket.nosdn.127.net/catchpic/f/f2/f25162d7d90e162600d70f155ed93f25.jpg","has_content":true,"docurl":"http://war.163.com/17/0523/09/CL44KLP2000181KT.html","id":4902,"time":"2017-05-23 09:55:28","title":"日本警方处理右翼组织 20名右翼分子驾照被吊销","channelname":"war"}]
     */

    private int size;
    private List<ListBean> list;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable{
        /**
         * imgurl : http://dingyue.nosdn.127.net/1vXUfazxJswOkuWkurqx3HYQh6VJTYBjXfKibXhXeUJ1z1495359006800transferflag.png
         * has_content : true
         * docurl : http://war.163.com/17/0523/10/CL46SK9G0001879A.html
         * id : 4949
         * time : 2017-05-23 10:34:46
         * title : 歼31与F35＂厮杀＂ 能胜？军迷表示一技术无人能敌
         * channelname : war
         */

        private String imgurl;
        private boolean has_content;
        private String docurl;
        private int id;
        private String time;
        private String title;
        private String channelname;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public boolean isHas_content() {
            return has_content;
        }

        public void setHas_content(boolean has_content) {
            this.has_content = has_content;
        }

        public String getDocurl() {
            return docurl;
        }

        public void setDocurl(String docurl) {
            this.docurl = docurl;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getChannelname() {
            return channelname;
        }

        public void setChannelname(String channelname) {
            this.channelname = channelname;
        }
    }
}

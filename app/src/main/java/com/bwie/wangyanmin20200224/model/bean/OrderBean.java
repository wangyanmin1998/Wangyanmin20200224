package com.bwie.wangyanmin20200224.model.bean;

import java.util.List;

/*
 *@auther:王彦敏
 *@Date: 2020/2/24
 *@Time:13:34
 *@Description:
 * */
public class OrderBean {


    /**
     * result : [{"giftPic":"http://mobile.bwstudent.com/images/live/gift/flower.png","handselTime":1582473600000,"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIypiccMxicMfqcZf0ORwicicwbNSdnDjMtbXu01p3Dg5dfFZSyjafXT6ZdK9dvO4wHPUls0KBw0udiaWg/132","nickName":"🍥 草莓小啾啾ぃ"},{"giftPic":"http://mobile.bwstudent.com/images/live/gift/ice_cream.png","handselTime":1582473600000,"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIypiccMxicMfqcZf0ORwicicwbNSdnDjMtbXu01p3Dg5dfFZSyjafXT6ZdK9dvO4wHPUls0KBw0udiaWg/132","nickName":"🍥 草莓小啾啾ぃ"},{"giftPic":"http://mobile.bwstudent.com/images/live/gift/ice_cream.png","handselTime":1582473600000,"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIypiccMxicMfqcZf0ORwicicwbNSdnDjMtbXu01p3Dg5dfFZSyjafXT6ZdK9dvO4wHPUls0KBw0udiaWg/132","nickName":"🍥 草莓小啾啾ぃ"},{"giftPic":"http://mobile.bwstudent.com/images/live/gift/ice_cream.png","handselTime":1582473600000,"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIypiccMxicMfqcZf0ORwicicwbNSdnDjMtbXu01p3Dg5dfFZSyjafXT6ZdK9dvO4wHPUls0KBw0udiaWg/132","nickName":"🍥 草莓小啾啾ぃ"},{"giftPic":"http://mobile.bwstudent.com/images/live/gift/flower.png","handselTime":1582473600000,"headPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIypiccMxicMfqcZf0ORwicicwbNSdnDjMtbXu01p3Dg5dfFZSyjafXT6ZdK9dvO4wHPUls0KBw0udiaWg/132","nickName":"🍥 草莓小啾啾ぃ"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * giftPic : http://mobile.bwstudent.com/images/live/gift/flower.png
         * handselTime : 1582473600000
         * headPic : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIypiccMxicMfqcZf0ORwicicwbNSdnDjMtbXu01p3Dg5dfFZSyjafXT6ZdK9dvO4wHPUls0KBw0udiaWg/132
         * nickName : 🍥 草莓小啾啾ぃ
         */

        private String giftPic;
        private long handselTime;
        private String headPic;
        private String nickName;

        public String getGiftPic() {
            return giftPic;
        }

        public void setGiftPic(String giftPic) {
            this.giftPic = giftPic;
        }

        public long getHandselTime() {
            return handselTime;
        }

        public void setHandselTime(long handselTime) {
            this.handselTime = handselTime;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }
    }
}

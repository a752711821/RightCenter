package com.example.myapplication.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class EnjoyGoodsEntity {


    /**
     * suuccess : true
     * msg : 获取成功
     * obj : [{"goodsFuseCode":"fuse20180621152034179","arType":"4","arName":"芒果会员周卡+3G国内流量","arDescribe":"仅需10元话费得3G168小时国内流量，加5元（或420积分）得芒果TV影视会员周卡！","areaCode":"024","dicId":"16","payType":"1,2","buyNum":"6890","onLineTime":"20180621000000","salePrice":"5","saleJfPrice":"420","arUrlPath":"http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180621152034179&neusoft_param=tg","arImagePath":"https://www.ln139.com/shlm/upload/o2o//20180621/20180621152439_DCkt.jpg","userStarLvLimit":"0"},{"goodsFuseCode":"fuse20180621145939450","arType":"4","arName":"优酷会员周卡+3G国内流量","arDescribe":"仅需10元话费得3G168小时国内流量，加6元（或504积分）得优酷VIP会员周卡！","areaCode":"024","dicId":"16","payType":"1,2","buyNum":"6985","onLineTime":"20180621000000","salePrice":"6","saleJfPrice":"504","arUrlPath":"http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180621145939450&neusoft_param=tg","arImagePath":"https://www.ln139.com/shlm/upload/o2o//20180621/20180621151330_VBDo.jpg","userStarLvLimit":"0"},{"goodsFuseCode":"fuse20180621153112247","arType":"4","arName":"爱奇艺会员周卡+3G国内流量","arDescribe":"仅需10元话费得3G168小时国内流量，加6元（或504积分）得爱奇艺VIP会员黄金周卡！","areaCode":"024","dicId":"16","payType":"1,2","buyNum":"11708","onLineTime":"20180621000000","salePrice":"6","saleJfPrice":"504","arUrlPath":"http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180621153112247&neusoft_param=tg","arImagePath":"https://www.ln139.com/shlm/upload/o2o//20180621/20180621153309_bFDw.jpg","userStarLvLimit":"0"},{"goodsFuseCode":"fuse20180621153716364","arType":"4","arName":"腾讯会员周卡+3G国内流量","arDescribe":"仅需10元话费得3G168小时国内流量，加6元（或504积分）得腾讯视频会员周卡！","areaCode":"024","dicId":"16","payType":"1,2","buyNum":"19751","onLineTime":"20180621000000","salePrice":"6","saleJfPrice":"504","arUrlPath":"http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180621153716364&neusoft_param=tg","arImagePath":"https://www.ln139.com/shlm/upload/o2o//20180621/20180621153825_nEhl.jpg","userStarLvLimit":"0"},{"goodsFuseCode":"fuse20180531091155915","arType":"4","arName":"爱奇艺月卡+6G爱奇艺流量月包","arDescribe":"仅需3元话费得6G国内视频定向流量月包，加16元（或1344积分）得爱奇艺月卡！","areaCode":"024","dicId":"16","payType":"1,2","buyNum":"96","onLineTime":"20180530000000","salePrice":"16","saleJfPrice":"1344","arUrlPath":"http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180531091155915&neusoft_param=tg","arImagePath":"https://www.ln139.com/shlm/upload/o2o//20180531/20180531091422_JZDA.png","userStarLvLimit":"0"},{"goodsFuseCode":"fuse20180531091954322","arType":"4","arName":"芒果月卡+6G芒果流量月包","arDescribe":"仅需3元话费得6G国内视频定向流量月包，加13元（或1092积分）得芒果月卡！","areaCode":"024","dicId":"16","payType":"1,2","buyNum":"52","onLineTime":"20180530000000","salePrice":"13","saleJfPrice":"1092","arUrlPath":"http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180531091954322&neusoft_param=tg","arImagePath":"https://www.ln139.com/shlm/upload/o2o//20180531/20180531103317_HJPv.png","userStarLvLimit":"0"},{"goodsFuseCode":"fuse20180530173036111","arType":"4","arName":"腾讯月卡+6G腾讯流量月包","arDescribe":"仅需3元话费得6G国内视频定向流量月包，加16元（或1344积分）得腾讯月卡！","areaCode":"024","dicId":"16","payType":"1,2","buyNum":"292","onLineTime":"20180530000000","salePrice":"16","saleJfPrice":"1344","arUrlPath":"http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180530173036111&neusoft_param=tg","arImagePath":"https://www.ln139.com/shlm/upload/o2o//20180530/20180530173214_IguC.jpg","userStarLvLimit":"0"},{"goodsFuseCode":"fuse20180531092424606","arType":"4","arName":"优酷月卡+6G优酷流量月包","arDescribe":"仅需3元话费得6G国内视频定向流量月包，加16元（或1344积分）得优酷月卡！","areaCode":"024","dicId":"16","payType":"1,2","buyNum":"249","onLineTime":"20180530000000","salePrice":"16","saleJfPrice":"1344","arUrlPath":"http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180531092424606&neusoft_param=tg","arImagePath":"https://www.ln139.com/shlm/upload/o2o//20180531/20180531092520_NGZv.png","userStarLvLimit":"0"},{"goodsFuseCode":"fuse20180531092234951","arType":"4","arName":"芒果季卡+6G芒果流量季包","arDescribe":"仅需9元话费得3个月每月6G国内视频定向流量，加34元（或2856积分）得芒果季卡！","areaCode":"024","dicId":"16","payType":"1,2","buyNum":"1","onLineTime":"20180530000000","salePrice":"34","saleJfPrice":"2856","arUrlPath":"http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180531092234951&neusoft_param=tg","arImagePath":"https://www.ln139.com/shlm/upload/o2o//20180531/20180531103146_hLlM.png","userStarLvLimit":"0"},{"goodsFuseCode":"fuse20180531092623871","arType":"4","arName":"优酷季卡+6G优酷流量季包","arDescribe":"仅需9元话费得3个月每月6G国内视频定向流量，加48元（或4032积分）得优酷季卡！","areaCode":"024","dicId":"16","payType":"1,2","buyNum":"29","onLineTime":"20180530000000","salePrice":"48","saleJfPrice":"4032","arUrlPath":"http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180531092623871&neusoft_param=tg","arImagePath":"https://www.ln139.com/shlm/upload/o2o//20180531/20180531092725_zYVa.png","userStarLvLimit":"0"}]
     */

    private boolean suuccess;
    private String msg;
    private List<ObjBean> obj;

    public boolean isSuuccess() {
        return suuccess;
    }

    public void setSuuccess(boolean suuccess) {
        this.suuccess = suuccess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean implements Parcelable {

        /**
         * goodsFuseCode : fuse20180621152034179
         * arType : 4
         * arName : 芒果会员周卡+3G国内流量
         * arDescribe : 仅需10元话费得3G168小时国内流量，加5元（或420积分）得芒果TV影视会员周卡！
         * areaCode : 024
         * dicId : 16
         * payType : 1,2
         * buyNum : 6890
         * onLineTime : 20180621000000
         * salePrice : 5
         * saleJfPrice : 420
         * arUrlPath : http://www.ln139.com/ILIAONING/goodsDetail.do?code=fuse20180621152034179&neusoft_param=tg
         * arImagePath : https://www.ln139.com/shlm/upload/o2o//20180621/20180621152439_DCkt.jpg
         * userStarLvLimit : 0
         */

        private String goodsFuseCode;
        private String arType;
        private String arName;
        private String arDescribe;
        private String areaCode;
        private String dicId;
        private String payType;
        private String buyNum;
        private String onLineTime;
        private String salePrice;
        private String saleJfPrice;
        private String arUrlPath;
        private String arImagePath;
        private String userStarLvLimit;

        public String getGoodsFuseCode() {
            return goodsFuseCode;
        }

        public void setGoodsFuseCode(String goodsFuseCode) {
            this.goodsFuseCode = goodsFuseCode;
        }

        public String getArType() {
            return arType;
        }

        public void setArType(String arType) {
            this.arType = arType;
        }

        public String getArName() {
            return arName;
        }

        public void setArName(String arName) {
            this.arName = arName;
        }

        public String getArDescribe() {
            return arDescribe;
        }

        public void setArDescribe(String arDescribe) {
            this.arDescribe = arDescribe;
        }

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getDicId() {
            return dicId;
        }

        public void setDicId(String dicId) {
            this.dicId = dicId;
        }

        public String getPayType() {
            return payType;
        }

        public void setPayType(String payType) {
            this.payType = payType;
        }

        public String getBuyNum() {
            return buyNum;
        }

        public void setBuyNum(String buyNum) {
            this.buyNum = buyNum;
        }

        public String getOnLineTime() {
            return onLineTime;
        }

        public void setOnLineTime(String onLineTime) {
            this.onLineTime = onLineTime;
        }

        public String getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(String salePrice) {
            this.salePrice = salePrice;
        }

        public String getSaleJfPrice() {
            return saleJfPrice;
        }

        public void setSaleJfPrice(String saleJfPrice) {
            this.saleJfPrice = saleJfPrice;
        }

        public String getArUrlPath() {
            return arUrlPath;
        }

        public void setArUrlPath(String arUrlPath) {
            this.arUrlPath = arUrlPath;
        }

        public String getArImagePath() {
            return arImagePath;
        }

        public void setArImagePath(String arImagePath) {
            this.arImagePath = arImagePath;
        }

        public String getUserStarLvLimit() {
            return userStarLvLimit;
        }

        public void setUserStarLvLimit(String userStarLvLimit) {
            this.userStarLvLimit = userStarLvLimit;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.goodsFuseCode);
            dest.writeString(this.arType);
            dest.writeString(this.arName);
            dest.writeString(this.arDescribe);
            dest.writeString(this.areaCode);
            dest.writeString(this.dicId);
            dest.writeString(this.payType);
            dest.writeString(this.buyNum);
            dest.writeString(this.onLineTime);
            dest.writeString(this.salePrice);
            dest.writeString(this.saleJfPrice);
            dest.writeString(this.arUrlPath);
            dest.writeString(this.arImagePath);
            dest.writeString(this.userStarLvLimit);
        }

        public ObjBean() {
        }

        protected ObjBean(Parcel in) {
            this.goodsFuseCode = in.readString();
            this.arType = in.readString();
            this.arName = in.readString();
            this.arDescribe = in.readString();
            this.areaCode = in.readString();
            this.dicId = in.readString();
            this.payType = in.readString();
            this.buyNum = in.readString();
            this.onLineTime = in.readString();
            this.salePrice = in.readString();
            this.saleJfPrice = in.readString();
            this.arUrlPath = in.readString();
            this.arImagePath = in.readString();
            this.userStarLvLimit = in.readString();
        }

        public static final Parcelable.Creator<ObjBean> CREATOR = new Parcelable.Creator<ObjBean>() {
            @Override
            public ObjBean createFromParcel(Parcel source) {
                return new ObjBean(source);
            }

            @Override
            public ObjBean[] newArray(int size) {
                return new ObjBean[size];
            }
        };
    }
}

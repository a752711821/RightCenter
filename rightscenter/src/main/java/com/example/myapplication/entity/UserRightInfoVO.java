package com.example.myapplication.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 用户权益信息详情
 *
 * @author ZTL
 */
public class UserRightInfoVO {

    /**
     * result : 0
     * list : {"data":[{"enjoyState":"0","permissionsName":"积分倍享","rightNumber":"1441","rightTitle":"当前积分","rightImage":"","leftTitle":"积分倍享","leftDesc":"每月倍享积分需在客户端首页-我的积分领取，点击下方按钮领取倍享积分。","bottomImgUrl":"http://221.180.150.136:7102/resources/images/quanyi/BOTTOMIMGURL/star3.png","bottomBtnName":"领取倍享积分","bottomBtnUrl":"https://www.ln139.com/ILIAONING/page/index/toIndexPage.jsp?neusoft_param=unctptlc","guaranteeNumber":"","guaranteeRemainingNumber":"","rightInfoCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOIMAGEURL/total.png","rightInfoUnCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOWHITEIMAGE/total.png"},{"enjoyState":"0","permissionsName":"话费透支","rightNumber":"0","rightTitle":"透支额度（元）","rightImage":"","leftTitle":"话费透支","leftDesc":"按照客户的信用度等级制定的，不同等级的信用度可以享受不同的话费透支额度。","bottomImgUrl":"","bottomBtnName":"前往话费充值","bottomBtnUrl":"充话费","guaranteeNumber":"","guaranteeRemainingNumber":"","rightInfoCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOIMAGEURL/money.png","rightInfoUnCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOWHITEIMAGE/money.png"},{"enjoyState":"1","permissionsName":"国漫免预存","rightNumber":"","rightTitle":"","rightImage":"","leftTitle":"开通国际漫游","leftDesc":"您尚未获得星级, 话费余额大于200即可开通。","bottomImgUrl":"","bottomBtnName":"开通","bottomBtnUrl":"开通国漫","guaranteeNumber":"","guaranteeRemainingNumber":"","rightInfoCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOIMAGEURL/fly.png","rightInfoUnCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOWHITEIMAGE/fly.png"},{"enjoyState":"0","permissionsName":"免费补换卡","rightNumber":"3","rightTitle":"免费补换卡（次）","rightImage":"","leftTitle":"免费补换卡","leftDesc":"三星（含）以上用户手机卡发生损坏或丢失后，可享受免费补换服务。","bottomImgUrl":"http://221.180.150.136:7102/resources/images/quanyi/BOTTOMIMGURL/card.png","bottomBtnName":"前往附近营业厅","bottomBtnUrl":"附近营业厅","guaranteeNumber":"","guaranteeRemainingNumber":"","rightInfoCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOIMAGEURL/card.png","rightInfoUnCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOWHITEIMAGE/card.png"},{"enjoyState":"1","permissionsName":"客服优先接","rightNumber":"","rightTitle":"","rightImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTNOIMAGE/no.png","leftTitle":"10086优先接入","leftDesc":"为五星（钻、金、普通）、四星服务客户提供10086优先接入服务。","bottomImgUrl":"","bottomBtnName":"拨打10086","bottomBtnUrl":"10086","guaranteeNumber":"","guaranteeRemainingNumber":"","rightInfoCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOIMAGEURL/10086.png","rightInfoUnCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOWHITEIMAGE/10086.png"},{"enjoyState":"0","permissionsName":"生日关怀","rightNumber":"","rightTitle":"","rightImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTIMAGE/birthday.png","leftTitle":"生日关怀","leftDesc":"三星及以上客户生日当天通过短信方式进行生日祝福及问候的服务。","bottomImgUrl":"","bottomBtnName":"","bottomBtnUrl":"","guaranteeNumber":"","guaranteeRemainingNumber":"","rightInfoCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOIMAGEURL/birthday.png","rightInfoUnCheckImage":"http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOWHITEIMAGE/birthday.png"}]}
     * error :
     * status :
     */

    private String result;
    private ListBean list;
    private String error;
    private String status;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ListBean getList() {
        return list;
    }

    public void setList(ListBean list) {
        this.list = list;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ListBean {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Parcelable {
            /**
             * enjoyState : 0
             * permissionsName : 积分倍享
             * rightNumber : 1441
             * rightTitle : 当前积分
             * rightImage :
             * leftTitle : 积分倍享
             * leftDesc : 每月倍享积分需在客户端首页-我的积分领取，点击下方按钮领取倍享积分。
             * bottomImgUrl : http://221.180.150.136:7102/resources/images/quanyi/BOTTOMIMGURL/star3.png
             * bottomBtnName : 领取倍享积分
             * bottomBtnUrl : https://www.ln139.com/ILIAONING/page/index/toIndexPage.jsp?neusoft_param=unctptlc
             * guaranteeNumber :
             * guaranteeRemainingNumber :
             * rightInfoCheckImage : http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOIMAGEURL/total.png
             * rightInfoUnCheckImage : http://221.180.150.136:7102/resources/images/quanyi/RIGHTINFOWHITEIMAGE/total.png
             */

            private String enjoyState;
            private String permissionsName;
            private String rightNumber;
            private String rightTitle;
            private String rightImage;
            private String leftTitle;
            private String leftDesc;
            private String bottomImgUrl;
            private String bottomBtnName;
            private String bottomBtnUrl;
            private String guaranteeNumber;
            private String guaranteeRemainingNumber;
            private String rightInfoCheckImage;
            private String rightInfoUnCheckImage;

            public String getEnjoyState() {
                return enjoyState;
            }

            public void setEnjoyState(String enjoyState) {
                this.enjoyState = enjoyState;
            }

            public String getPermissionsName() {
                return permissionsName;
            }

            public void setPermissionsName(String permissionsName) {
                this.permissionsName = permissionsName;
            }

            public String getRightNumber() {
                return rightNumber;
            }

            public void setRightNumber(String rightNumber) {
                this.rightNumber = rightNumber;
            }

            public String getRightTitle() {
                return rightTitle;
            }

            public void setRightTitle(String rightTitle) {
                this.rightTitle = rightTitle;
            }

            public String getRightImage() {
                return rightImage;
            }

            public void setRightImage(String rightImage) {
                this.rightImage = rightImage;
            }

            public String getLeftTitle() {
                return leftTitle;
            }

            public void setLeftTitle(String leftTitle) {
                this.leftTitle = leftTitle;
            }

            public String getLeftDesc() {
                return leftDesc;
            }

            public void setLeftDesc(String leftDesc) {
                this.leftDesc = leftDesc;
            }

            public String getBottomImgUrl() {
                return bottomImgUrl;
            }

            public void setBottomImgUrl(String bottomImgUrl) {
                this.bottomImgUrl = bottomImgUrl;
            }

            public String getBottomBtnName() {
                return bottomBtnName;
            }

            public void setBottomBtnName(String bottomBtnName) {
                this.bottomBtnName = bottomBtnName;
            }

            public String getBottomBtnUrl() {
                return bottomBtnUrl;
            }

            public void setBottomBtnUrl(String bottomBtnUrl) {
                this.bottomBtnUrl = bottomBtnUrl;
            }

            public String getGuaranteeNumber() {
                return guaranteeNumber;
            }

            public void setGuaranteeNumber(String guaranteeNumber) {
                this.guaranteeNumber = guaranteeNumber;
            }

            public String getGuaranteeRemainingNumber() {
                return guaranteeRemainingNumber;
            }

            public void setGuaranteeRemainingNumber(String guaranteeRemainingNumber) {
                this.guaranteeRemainingNumber = guaranteeRemainingNumber;
            }

            public String getRightInfoCheckImage() {
                return rightInfoCheckImage;
            }

            public void setRightInfoCheckImage(String rightInfoCheckImage) {
                this.rightInfoCheckImage = rightInfoCheckImage;
            }

            public String getRightInfoUnCheckImage() {
                return rightInfoUnCheckImage;
            }

            public void setRightInfoUnCheckImage(String rightInfoUnCheckImage) {
                this.rightInfoUnCheckImage = rightInfoUnCheckImage;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.enjoyState);
                dest.writeString(this.permissionsName);
                dest.writeString(this.rightNumber);
                dest.writeString(this.rightTitle);
                dest.writeString(this.rightImage);
                dest.writeString(this.leftTitle);
                dest.writeString(this.leftDesc);
                dest.writeString(this.bottomImgUrl);
                dest.writeString(this.bottomBtnName);
                dest.writeString(this.bottomBtnUrl);
                dest.writeString(this.guaranteeNumber);
                dest.writeString(this.guaranteeRemainingNumber);
                dest.writeString(this.rightInfoCheckImage);
                dest.writeString(this.rightInfoUnCheckImage);
            }

            public DataBean() {
            }

            protected DataBean(Parcel in) {
                this.enjoyState = in.readString();
                this.permissionsName = in.readString();
                this.rightNumber = in.readString();
                this.rightTitle = in.readString();
                this.rightImage = in.readString();
                this.leftTitle = in.readString();
                this.leftDesc = in.readString();
                this.bottomImgUrl = in.readString();
                this.bottomBtnName = in.readString();
                this.bottomBtnUrl = in.readString();
                this.guaranteeNumber = in.readString();
                this.guaranteeRemainingNumber = in.readString();
                this.rightInfoCheckImage = in.readString();
                this.rightInfoUnCheckImage = in.readString();
            }

            public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
                @Override
                public DataBean createFromParcel(Parcel source) {
                    return new DataBean(source);
                }

                @Override
                public DataBean[] newArray(int size) {
                    return new DataBean[size];
                }
            };
        }
    }
}

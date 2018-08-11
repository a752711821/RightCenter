package com.example.myapplication.entity;

import java.util.List;

public class LxzbEntity {


    /**
     * result : 0
     * list : {"Business":[{"merchantNumber":"busi20161212102147563","merchantPhone":"","storeNumber":"shop20161212103919447","cityNumber":"024","cityName":"闉嶅北","storeAddress":"闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵\u20ac鍖�30绫�","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"04127763777","storePicture":"http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鍚�","storeConsumption":"60","businessHours":"09:00-21:00","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20130704094401194","merchantPhone":"04152888019","storeNumber":"shop69483","cityNumber":"024","cityName":"涓逛笢","storeAddress":"涓逛笢甯傚厓瀹濆尯閿﹀北澶ц53-6鍙峰疂灞卞コ浜鸿鏃�","coordinateX":"124.4036135","coordinateY":"40.14184652","storePhone":"04152888019","storePicture":"http://shop.ln139.com/shlm/upload/shop0415/201307/69483/20130704155901_NmUf.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鏄�","storeConsumption":"30","businessHours":"10:00-21:30","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20160816130410167","merchantPhone":"","storeNumber":"shop20160816154945570","cityNumber":"024","cityName":"鏈邯","storeAddress":"鏈邯甯傛浠佹弧鏃忚嚜娌诲幙榛庢槑琛�32鍙峰疄楠屽皬瀛﹀闈㈣繋钖伴棬宸︿晶","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"13700010442","storePicture":"http://shop.ln139.com/shlm/upload/shop/20160816/20160816155630_uBXs.jpg","storeId":"226","storeClassification":"缇庨","parkingSpace":"鏄�","storeConsumption":"60","businessHours":"08:30-22:00","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20161212102147564","merchantPhone":"","storeNumber":"shop20161212103919447","cityNumber":"024","cityName":"闉嶅北","storeAddress":"闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵\u20ac鍖�30绫�","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"04127763777","storePicture":"http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鍚�","storeConsumption":"60","businessHours":"09:00-21:00","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20161212102147565","merchantPhone":"","storeNumber":"shop20161212103919447","cityNumber":"024","cityName":"闉嶅北","storeAddress":"闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵\u20ac鍖�30绫�","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"04127763777","storePicture":"http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鍚�","storeConsumption":"60","businessHours":"09:00-21:00","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20161212102147566","merchantPhone":"","storeNumber":"shop20161212103919447","cityNumber":"024","cityName":"闉嶅北","storeAddress":"闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵\u20ac鍖�30绫�","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"04127763777","storePicture":"http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鍚�","storeConsumption":"60","businessHours":"09:00-21:00","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20161212102147567","merchantPhone":"","storeNumber":"shop20161212103919447","cityNumber":"024","cityName":"闉嶅北","storeAddress":"闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵\u20ac鍖�30绫�","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"04127763777","storePicture":"http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鍚�","storeConsumption":"60","businessHours":"09:00-21:00","trafficInformation":"","merchantName":"","storeName":""}],"show":"0"}
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
        /**
         * Business : [{"merchantNumber":"busi20161212102147563","merchantPhone":"","storeNumber":"shop20161212103919447","cityNumber":"024","cityName":"闉嶅北","storeAddress":"闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵\u20ac鍖�30绫�","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"04127763777","storePicture":"http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鍚�","storeConsumption":"60","businessHours":"09:00-21:00","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20130704094401194","merchantPhone":"04152888019","storeNumber":"shop69483","cityNumber":"024","cityName":"涓逛笢","storeAddress":"涓逛笢甯傚厓瀹濆尯閿﹀北澶ц53-6鍙峰疂灞卞コ浜鸿鏃�","coordinateX":"124.4036135","coordinateY":"40.14184652","storePhone":"04152888019","storePicture":"http://shop.ln139.com/shlm/upload/shop0415/201307/69483/20130704155901_NmUf.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鏄�","storeConsumption":"30","businessHours":"10:00-21:30","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20160816130410167","merchantPhone":"","storeNumber":"shop20160816154945570","cityNumber":"024","cityName":"鏈邯","storeAddress":"鏈邯甯傛浠佹弧鏃忚嚜娌诲幙榛庢槑琛�32鍙峰疄楠屽皬瀛﹀闈㈣繋钖伴棬宸︿晶","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"13700010442","storePicture":"http://shop.ln139.com/shlm/upload/shop/20160816/20160816155630_uBXs.jpg","storeId":"226","storeClassification":"缇庨","parkingSpace":"鏄�","storeConsumption":"60","businessHours":"08:30-22:00","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20161212102147564","merchantPhone":"","storeNumber":"shop20161212103919447","cityNumber":"024","cityName":"闉嶅北","storeAddress":"闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵\u20ac鍖�30绫�","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"04127763777","storePicture":"http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鍚�","storeConsumption":"60","businessHours":"09:00-21:00","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20161212102147565","merchantPhone":"","storeNumber":"shop20161212103919447","cityNumber":"024","cityName":"闉嶅北","storeAddress":"闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵\u20ac鍖�30绫�","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"04127763777","storePicture":"http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鍚�","storeConsumption":"60","businessHours":"09:00-21:00","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20161212102147566","merchantPhone":"","storeNumber":"shop20161212103919447","cityNumber":"024","cityName":"闉嶅北","storeAddress":"闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵\u20ac鍖�30绫�","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"04127763777","storePicture":"http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鍚�","storeConsumption":"60","businessHours":"09:00-21:00","trafficInformation":"","merchantName":"","storeName":""},{"merchantNumber":"busi20161212102147567","merchantPhone":"","storeNumber":"shop20161212103919447","cityNumber":"024","cityName":"闉嶅北","storeAddress":"闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵\u20ac鍖�30绫�","coordinateX":"123.431459","coordinateY":"41.805718","storePhone":"04127763777","storePicture":"http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg","storeId":"3","storeClassification":"浼戦棽濞变箰","parkingSpace":"鍚�","storeConsumption":"60","businessHours":"09:00-21:00","trafficInformation":"","merchantName":"","storeName":""}]
         * show : 0
         */

        private String show;
        private List<BusinessBean> Business;

        public String getShow() {
            return show;
        }

        public void setShow(String show) {
            this.show = show;
        }

        public List<BusinessBean> getBusiness() {
            return Business;
        }

        public void setBusiness(List<BusinessBean> Business) {
            this.Business = Business;
        }

        public static class BusinessBean {
            /**
             * merchantNumber : busi20161212102147563
             * merchantPhone :
             * storeNumber : shop20161212103919447
             * cityNumber : 024
             * cityName : 闉嶅北
             * storeAddress : 闉嶅北甯傚搏宀╂弧鏃忚嚜娌诲幙宀博闀囬槣鏄岃矾鍖楅棬娲惧嚭鎵€鍖�30绫�
             * coordinateX : 123.431459
             * coordinateY : 41.805718
             * storePhone : 04127763777
             * storePicture : http://shop.ln139.com/shlm/upload/shop/20161212/20161212104736_Sjwi.jpg
             * storeId : 3
             * storeClassification : 浼戦棽濞变箰
             * parkingSpace : 鍚�
             * storeConsumption : 60
             * businessHours : 09:00-21:00
             * trafficInformation :
             * merchantName :
             * storeName :
             */

            private String merchantNumber;
            private String merchantPhone;
            private String storeNumber;
            private String cityNumber;
            private String cityName;
            private String storeAddress;
            private String coordinateX;
            private String coordinateY;
            private String storePhone;
            private String storePicture;
            private String storeId;
            private String storeClassification;
            private String parkingSpace;
            private String storeConsumption;
            private String businessHours;
            private String trafficInformation;
            private String merchantName;
            private String storeName;

            public String getMerchantNumber() {
                return merchantNumber;
            }

            public void setMerchantNumber(String merchantNumber) {
                this.merchantNumber = merchantNumber;
            }

            public String getMerchantPhone() {
                return merchantPhone;
            }

            public void setMerchantPhone(String merchantPhone) {
                this.merchantPhone = merchantPhone;
            }

            public String getStoreNumber() {
                return storeNumber;
            }

            public void setStoreNumber(String storeNumber) {
                this.storeNumber = storeNumber;
            }

            public String getCityNumber() {
                return cityNumber;
            }

            public void setCityNumber(String cityNumber) {
                this.cityNumber = cityNumber;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getStoreAddress() {
                return storeAddress;
            }

            public void setStoreAddress(String storeAddress) {
                this.storeAddress = storeAddress;
            }

            public String getCoordinateX() {
                return coordinateX;
            }

            public void setCoordinateX(String coordinateX) {
                this.coordinateX = coordinateX;
            }

            public String getCoordinateY() {
                return coordinateY;
            }

            public void setCoordinateY(String coordinateY) {
                this.coordinateY = coordinateY;
            }

            public String getStorePhone() {
                return storePhone;
            }

            public void setStorePhone(String storePhone) {
                this.storePhone = storePhone;
            }

            public String getStorePicture() {
                return storePicture;
            }

            public void setStorePicture(String storePicture) {
                this.storePicture = storePicture;
            }

            public String getStoreId() {
                return storeId;
            }

            public void setStoreId(String storeId) {
                this.storeId = storeId;
            }

            public String getStoreClassification() {
                return storeClassification;
            }

            public void setStoreClassification(String storeClassification) {
                this.storeClassification = storeClassification;
            }

            public String getParkingSpace() {
                return parkingSpace;
            }

            public void setParkingSpace(String parkingSpace) {
                this.parkingSpace = parkingSpace;
            }

            public String getStoreConsumption() {
                return storeConsumption;
            }

            public void setStoreConsumption(String storeConsumption) {
                this.storeConsumption = storeConsumption;
            }

            public String getBusinessHours() {
                return businessHours;
            }

            public void setBusinessHours(String businessHours) {
                this.businessHours = businessHours;
            }

            public String getTrafficInformation() {
                return trafficInformation;
            }

            public void setTrafficInformation(String trafficInformation) {
                this.trafficInformation = trafficInformation;
            }

            public String getMerchantName() {
                return merchantName;
            }

            public void setMerchantName(String merchantName) {
                this.merchantName = merchantName;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }
        }
    }
}

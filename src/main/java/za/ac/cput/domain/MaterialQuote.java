package za.ac.cput.domain;

/*
   Entity for MaterialQuote
   Author: Carlo Joshua Joseph (2206210781)
   Date: 23/06/10
*/

public class MaterialQuote {
    private String materialQuoteId;
    private String materialName;
    private double materialPrice;
    private String materialQuantity;
    private double materialWeight;

    public MaterialQuote(Builder builder) {
        this.materialQuoteId = builder.materialQuoteId;
        this.materialName = builder.materialName;
        this.materialPrice = builder.materialPrice;
        this.materialQuantity = builder.materialQuantity;
        this.materialWeight = builder.materialWeight;
    }

    public String getMaterialQuoteId() {
        return materialQuoteId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public double getMaterialPrice() {
        return materialPrice;
    }

    public String getMaterialQuantity() {
        return materialQuantity;
    }

    public double getMaterialWeight() {
        return materialWeight;
    }

    @Override
    public String toString() {
        return "MaterialQuote{" +
                "materialQuoteId='" + materialQuoteId + '\'' +
                ", materialName='" + materialName + '\'' +
                ", materialPrice=" + materialPrice +
                ", materialQuantity='" + materialQuantity + '\'' +
                ", materialWeight=" + materialWeight +
                '}';
    }

    public static class Builder {
        private String materialQuoteId;
        private String materialName;
        private double materialPrice;
        private String materialQuantity;
        private double materialWeight;

        public Builder setMaterialQuoteId(String materialQuoteId) {
            this.materialQuoteId = materialQuoteId;
            return this;
        }

        public Builder setMaterialName(String materialName) {
            this.materialName = materialName;
            return this;
        }

        public Builder setMaterialPrice(double materialPrice) {
            this.materialPrice = materialPrice;
            return this;
        }

        public Builder setMaterialQuantity(String materialQuantity) {
            this.materialQuantity = materialQuantity;
            return this;
        }

        public Builder setMaterialWeight(double materialWeight) {
            this.materialWeight = materialWeight;
            return this;
        }

        public Builder copy(MaterialQuote materialQuote) {
            this.materialQuoteId = materialQuote.materialQuoteId;
            this.materialName = materialQuote.materialName;
            this.materialPrice = materialQuote.materialPrice;
            this.materialQuantity = materialQuote.materialQuantity;
            this.materialWeight = materialQuote.materialWeight;
            return this;
        }

        public MaterialQuote build() {
            return new MaterialQuote(this);
        }
    }
}

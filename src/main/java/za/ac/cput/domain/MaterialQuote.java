package za.ac.cput.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "MaterialQuote", schema = "")
public class MaterialQuote {

    @Id
    private String materialQuoteId;

    @Column(name = "materialName")
    private String materialName;

    @Column(name = "materialPrice")
    private double materialPrice;

    @Column(name = "materialQuantity")
    private String materialQuantity;

    @Column(name = "materialWeight")
    private double materialWeight;

    protected MaterialQuote() {
    }

    protected MaterialQuote(Builder builder) {
        this.materialQuoteId = builder.materialQuoteId;
        this.materialName = builder.materialName;
        this.materialPrice = builder.materialPrice;
        this.materialQuantity = builder.materialQuantity;
        this.materialWeight = builder.materialWeight;
    }
    public MaterialQuote(String materialQuoteId, String materialName, Double materialPrice, String materialQuantity, Double materialWeight) {
        this.materialQuoteId=materialQuoteId;
        this.materialName=materialName;
        this.materialPrice=materialPrice;
        this.materialQuantity=materialQuantity;
        this.materialWeight=materialWeight;

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


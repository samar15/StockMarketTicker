    package com.learning.ticker.model;

    import android.os.Parcel;
    import android.os.Parcelable;

    public class TickerDto implements Parcelable {
    private String language;
    private String region;
    private String quoteType;
    private Boolean triggerable;
    private String quoteSourceName;
    private String exchange;
    private Float regularMarketChangePercent;
    private Float regularMarketPreviousClose;
    private String fullExchangeName;
    private String longName;
    private Integer sourceInterval;
    private String exchangeTimezoneName;
    private String exchangeTimezoneShortName;
    private Long gmtOffSetMilliseconds;
    private String marketState;
    private Integer priceHint;
    private String shortName;
    private Float regularMarketPrice;
    private Integer regularMarketTime;
    private Float regularMarketChange;
    private Boolean esgPopulated;
    private Boolean tradeable;
    private String market;
    private Integer exchangeDataDelayedBy;
    private String symbol;

        protected TickerDto(Parcel in) {
            language = in.readString();
            region = in.readString();
            quoteType = in.readString();
            byte tmpTriggerable = in.readByte();
            triggerable = tmpTriggerable == 0 ? null : tmpTriggerable == 1;
            quoteSourceName = in.readString();
            exchange = in.readString();
            if (in.readByte() == 0) {
                regularMarketChangePercent = null;
            } else {
                regularMarketChangePercent = in.readFloat();
            }
            if (in.readByte() == 0) {
                regularMarketPreviousClose = null;
            } else {
                regularMarketPreviousClose = in.readFloat();
            }
            fullExchangeName = in.readString();
            longName = in.readString();
            if (in.readByte() == 0) {
                sourceInterval = null;
            } else {
                sourceInterval = in.readInt();
            }
            exchangeTimezoneName = in.readString();
            exchangeTimezoneShortName = in.readString();
            if (in.readByte() == 0) {
                gmtOffSetMilliseconds = null;
            } else {
                gmtOffSetMilliseconds = in.readLong();
            }
            marketState = in.readString();
            if (in.readByte() == 0) {
                priceHint = null;
            } else {
                priceHint = in.readInt();
            }
            shortName = in.readString();
            if (in.readByte() == 0) {
                regularMarketPrice = null;
            } else {
                regularMarketPrice = in.readFloat();
            }
            if (in.readByte() == 0) {
                regularMarketTime = null;
            } else {
                regularMarketTime = in.readInt();
            }
            if (in.readByte() == 0) {
                regularMarketChange = null;
            } else {
                regularMarketChange = in.readFloat();
            }
            byte tmpEsgPopulated = in.readByte();
            esgPopulated = tmpEsgPopulated == 0 ? null : tmpEsgPopulated == 1;
            byte tmpTradeable = in.readByte();
            tradeable = tmpTradeable == 0 ? null : tmpTradeable == 1;
            market = in.readString();
            if (in.readByte() == 0) {
                exchangeDataDelayedBy = null;
            } else {
                exchangeDataDelayedBy = in.readInt();
            }
            symbol = in.readString();
        }

        public static final Creator<TickerDto> CREATOR = new Creator<TickerDto>() {
            @Override
            public TickerDto createFromParcel(Parcel in) {
                return new TickerDto(in);
            }

            @Override
            public TickerDto[] newArray(int size) {
                return new TickerDto[size];
            }
        };

        public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }

    public Boolean getTriggerable() {
        return triggerable;
    }

    public void setTriggerable(Boolean triggerable) {
        this.triggerable = triggerable;
    }

    public String getQuoteSourceName() {
        return quoteSourceName;
    }

    public void setQuoteSourceName(String quoteSourceName) {
        this.quoteSourceName = quoteSourceName;
    }

    public Float getRegularMarketChangePercent() {
        return regularMarketChangePercent;
    }

    public void setRegularMarketChangePercent(Float regularMarketChangePercent) {
        this.regularMarketChangePercent = regularMarketChangePercent;
    }

    public Float getRegularMarketPreviousClose() {
        return regularMarketPreviousClose;
    }

    public void setRegularMarketPreviousClose(Float regularMarketPreviousClose) {
        this.regularMarketPreviousClose = regularMarketPreviousClose;
    }

    public String getFullExchangeName() {
        return fullExchangeName;
    }

    public void setFullExchangeName(String fullExchangeName) {
        this.fullExchangeName = fullExchangeName;
    }

    public Float getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(Float regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public Integer getRegularMarketTime() {
        return regularMarketTime;
    }

    public void setRegularMarketTime(Integer regularMarketTime) {
        this.regularMarketTime = regularMarketTime;
    }

    public Float getRegularMarketChange() {
        return regularMarketChange;
    }

    public void setRegularMarketChange(Float regularMarketChange) {
        this.regularMarketChange = regularMarketChange;
    }

    public Boolean getEsgPopulated() {
        return esgPopulated;
    }

    public void setEsgPopulated(Boolean esgPopulated) {
        this.esgPopulated = esgPopulated;
    }

    public Boolean getTradeable() {
        return tradeable;
    }

    public void setTradeable(Boolean tradeable) {
        this.tradeable = tradeable;
    }

    public Integer getSourceInterval() {
        return sourceInterval;
    }

    public void setSourceInterval(Integer sourceInterval) {
        this.sourceInterval = sourceInterval;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    public void setExchangeTimezoneName(String exchangeTimezoneName) {
        this.exchangeTimezoneName = exchangeTimezoneName;
    }

    public String getExchangeTimezoneShortName() {
        return exchangeTimezoneShortName;
    }

    public void setExchangeTimezoneShortName(String exchangeTimezoneShortName) {
        this.exchangeTimezoneShortName = exchangeTimezoneShortName;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getExchangeDataDelayedBy() {
        return exchangeDataDelayedBy;
    }

    public void setExchangeDataDelayedBy(Integer exchangeDataDelayedBy) {
        this.exchangeDataDelayedBy = exchangeDataDelayedBy;
    }

    public String getMarketState() {
        return marketState;
    }

    public void setMarketState(String marketState) {
        this.marketState = marketState;
    }

    public Long getGmtOffSetMilliseconds() {
        return gmtOffSetMilliseconds;
    }

    public void setGmtOffSetMilliseconds(Long gmtOffSetMilliseconds) {
        this.gmtOffSetMilliseconds = gmtOffSetMilliseconds;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }
    public Integer getPriceHint() {
        return priceHint;
    }

    public void setPriceHint(Integer priceHint) {
        this.priceHint = priceHint;
    }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(language);
            parcel.writeString(region);
            parcel.writeString(quoteType);
            parcel.writeByte((byte) (triggerable == null ? 0 : triggerable ? 1 : 2));
            parcel.writeString(quoteSourceName);
            parcel.writeString(exchange);
            if (regularMarketChangePercent == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeFloat(regularMarketChangePercent);
            }
            if (regularMarketPreviousClose == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeFloat(regularMarketPreviousClose);
            }
            parcel.writeString(fullExchangeName);
            parcel.writeString(longName);
            if (sourceInterval == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(sourceInterval);
            }
            parcel.writeString(exchangeTimezoneName);
            parcel.writeString(exchangeTimezoneShortName);
            if (gmtOffSetMilliseconds == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeLong(gmtOffSetMilliseconds);
            }
            parcel.writeString(marketState);
            if (priceHint == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(priceHint);
            }
            parcel.writeString(shortName);
            if (regularMarketPrice == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeFloat(regularMarketPrice);
            }
            if (regularMarketTime == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(regularMarketTime);
            }
            if (regularMarketChange == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeFloat(regularMarketChange);
            }
            parcel.writeByte((byte) (esgPopulated == null ? 0 : esgPopulated ? 1 : 2));
            parcel.writeByte((byte) (tradeable == null ? 0 : tradeable ? 1 : 2));
            parcel.writeString(market);
            if (exchangeDataDelayedBy == null) {
                parcel.writeByte((byte) 0);
            } else {
                parcel.writeByte((byte) 1);
                parcel.writeInt(exchangeDataDelayedBy);
            }
            parcel.writeString(symbol);
        }
    }
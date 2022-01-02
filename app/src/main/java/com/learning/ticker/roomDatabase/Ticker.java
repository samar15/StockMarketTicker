package com.learning.ticker.roomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ticker {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "language")
    public String language;

    @ColumnInfo(name = "region")
    public String region;

    @ColumnInfo(name = "quote_type")
    public String quoteType;

    @ColumnInfo(name = "triggerable")
    public Boolean triggerable;

    @ColumnInfo(name = "quote_source_name")
    public String quoteSourceName;

    @ColumnInfo(name = "exchange")
    public String exchange;

    @ColumnInfo(name = "regular_market_change_percent")
    public Float regularMarketChangePercent;

    @ColumnInfo(name = "regular_market_previous_close")
    public Float regularMarketPreviousClose;

    @ColumnInfo(name = "full_exchange_name")
    public String fullExchangeName;

    @ColumnInfo(name = "long_name")
    public String longName;

    @ColumnInfo(name = "source_interval")
    public Integer sourceInterval;

    @ColumnInfo(name = "exchange_timezone_name")
    public String exchangeTimezoneName;

    @ColumnInfo(name = "exchange_timezone_short_name")
    public String exchangeTimezoneShortName;

    @ColumnInfo(name = "gmt_off_set_milliseconds")
    public Long gmtOffSetMilliseconds;

    @ColumnInfo(name = "market_state")
    public String marketState;

    @ColumnInfo(name = "price_hint")
    public Integer priceHint;

    @ColumnInfo(name = "short_name")
    public String shortName;

    @ColumnInfo(name = "regular_market_price")
    public Float regularMarketPrice;

    @ColumnInfo(name = "regular_market_time")
    public Integer regularMarketTime;

    @ColumnInfo(name = "regular_market_change")
    public Float regularMarketChange;

    @ColumnInfo(name = "esg_populated")
    public Boolean esgPopulated;

    @ColumnInfo(name = "tradeable")
    public Boolean tradeable;

    @ColumnInfo(name = "market")
    public String market;

    @ColumnInfo(name = "exchange_data_delayed_by")
    public Integer exchangeDataDelayedBy;

    @ColumnInfo(name = "symbol")
    public String symbol;
}

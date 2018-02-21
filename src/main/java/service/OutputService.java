package service;

import crypto.CryptoCurrency;
import dnl.utils.text.table.TextTable;

import java.util.List;

public class OutputService {

    private static String[] columnNames = {
        "id",
        "name",
        "symbol",
        "rank",
        "price_usd",
        "price_btc",
        "24h_volume_usd",
        "market_cap_usd",
        "available_supply",
        "total_supply",
        "max_supply",
        "percent_change_1h",
        "percent_change_24h",
        "percent_change_7d",
        "last_updated"
    };

    void printTable(List<CryptoCurrency> currenciesList) {

        CryptoCurrency[] cryptoCurrenciesArray = (CryptoCurrency[]) currenciesList.toArray();
        int cryptoCurrenciesArraySize = cryptoCurrenciesArray.length;
        int cryptoCurrencyFieldsNumber = 15;

        Object[][] data = new Object[cryptoCurrenciesArraySize][cryptoCurrencyFieldsNumber];

        for (int i = 0; i < cryptoCurrenciesArraySize; i++) {
            Object[] array = new Object[]{ cryptoCurrenciesArray[i].getId(), cryptoCurrenciesArray[i].getName(),
                                           cryptoCurrenciesArray[i].getSymbol(), cryptoCurrenciesArray[i].getRank(),
                                           cryptoCurrenciesArray[i].getPriceUsd(), cryptoCurrenciesArray[i].getPriceBtc(),
                                           cryptoCurrenciesArray[i].getVolumeUsd24(), cryptoCurrenciesArray[i].getMarketCapUsd(),
                                           cryptoCurrenciesArray[i].getAvailableSupply(), cryptoCurrenciesArray[i].getTotalSupply(),
                                           cryptoCurrenciesArray[i].getMaxSupply(), cryptoCurrenciesArray[i].getPercent1(),
                                           cryptoCurrenciesArray[i].getPercent24(), cryptoCurrenciesArray[i].getPercent7d(),
                                           cryptoCurrenciesArray[i].getLastUpdate() };
            data[i] = array;
        }

        TextTable tt = new TextTable(columnNames, data);
        tt.setAddRowNumbering( true );
        tt.setSort( 2 );
        tt.printTable();
    }
}

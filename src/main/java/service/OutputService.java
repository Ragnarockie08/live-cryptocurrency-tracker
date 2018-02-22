package service;

import crypto.CryptoCurrency;
import dnl.utils.text.table.TextTable;
import java.util.List;

public class OutputService {

    private static int columnNumberToSortBy;

    private static String[] columnNames = {
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
        "last_updated"
    };

    void printTable(List<CryptoCurrency> currenciesList) {

        if (!currenciesList.isEmpty()) {
            int cryptoCurrenciesArraySize = currenciesList.size();
            int cryptoCurrencyFieldsNumber = 14;

            Object[][] data = new Object[cryptoCurrenciesArraySize][cryptoCurrencyFieldsNumber];

            for (int i = 0; i < cryptoCurrenciesArraySize; i++) {
                Object[] array = new Object[]{currenciesList.get(i).getName(),
                        currenciesList.get(i).getSymbol(), currenciesList.get(i).getRank(),
                        currenciesList.get(i).getPriceUsd(), currenciesList.get(i).getPriceBtc(),
                        currenciesList.get(i).getVolumeUsd24(), currenciesList.get(i).getMarketCapUsd(),
                        currenciesList.get(i).getAvailableSupply(), currenciesList.get(i).getTotalSupply(),
                        currenciesList.get(i).getMaxSupply(), currenciesList.get(i).getPercent1(),
                        currenciesList.get(i).getPercent24(), currenciesList.get(i).getLastUpdate() };
                data[i] = array;
            }

            TextTable tt = new TextTable(columnNames, data);
            tt.setAddRowNumbering( true );
            tt.setSort( columnNumberToSortBy );
            tt.printTable();
        }
    }

    public static void setColumnNumberToSortBy(int columnNumberToSortBy) {
        OutputService.columnNumberToSortBy = columnNumberToSortBy;
    }
}
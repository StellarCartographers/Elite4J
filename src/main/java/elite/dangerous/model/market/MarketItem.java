package elite.dangerous.model.market;

import lombok.EliteObject;

@EliteObject public class MarketItem
{

    private int id, buyPrice, sellPrice, meanPrice, stockBracket, demandBracket, stock, demand;

    private String name, category;

    private boolean consumer, producer, rare;
}

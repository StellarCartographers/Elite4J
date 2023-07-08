/**
 * Copyright (c) 2023  The Stellar Cartographers' Guild. All rights reserved.
 *
 * This work is licensed under the terms of the MIT license.
 * For a copy, see <https://opensource.org/licenses/MIT>.
 */
package elite.dangerous.models;
/**
 * The Class MicroResource.
 */
public class MicroResource
{
    /**
     * The name.
     */
    public String   name;
    /**
     * The name localised.
     */
    public String   nameLocalised;
    /**
     * The category.
     */
    public Category category;
    /**
     * The count.
     */
    public Integer  count;

    /**
     * The Enum Category.
     */
    public enum Category
    {
        Encoded, Raw, Manufactured, Item, Component, Data, Consumable,
    }
}

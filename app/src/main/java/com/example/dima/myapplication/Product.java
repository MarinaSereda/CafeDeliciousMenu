package com.example.dima.myapplication;

public class Product{
    // Relative layout лічильник кількості елементів
    int soupCount = 6;
    int appetizerCount = 7;
    int dessertsCount = 6;
    int beverageCount = 4;

    public int itemCount(String res) {
        switch (res) {
            case "soup":
                return soupCount;
            case "appetizer":
                return appetizerCount;
            case "desserts":
                return dessertsCount;
            case "beverages":
                return beverageCount;
            default:
                return 0;
        }
    }

    // дані для супа
    private String[] soupName = {
            "Chicken Veg Soup", "Italian Tomato Soup",
            "Mushroom Soup", "Potato Leek Soup",
            "Thai Spices Soup", "Tomato Basil Soup"
    };
    private int[] drawableSoupId = {
            R.drawable.soup_chicken_veg_soup, R.drawable.soup_italian_tomato_soup,
            R.drawable.soup_mushroom_soup, R.drawable.soup_potato_leek_soup,
            R.drawable.soup_thai_spices_soup, R.drawable.soup_tomato_basil_soup
    };
    private String[] soupPrice = {
            "$6", "$10",
            "$8", "$5",
            "$12" ,"$11"
    };

    public String[] getSoupName() {
        return soupName;
    }

    public int[] getDrawableSoupId() {
        return drawableSoupId;
    }

    public String[] getSoupPrice() {
        return soupPrice;
    }

    // дані про закуски
    private String[] appetizerName = {
            "Omelette","Caesar Salad",
            "House Salad" , "Chicken",
            "Cheese Perogies", "Cheeseburger",
            "Sampler"

    };
    private int[] drawableAppetizerId = {
            R.drawable.appetizer_omelette, R.drawable.appetizer_ceasar_salad,
            R.drawable.appetizer_house_salad, R.drawable.appetizer_chicken,
            R.drawable.appetizer_cheese_perogies, R.drawable.appetizer_cheeseburger,
            R.drawable.appetizer_sampler
    };
    private String[] appetizerPrice = {
            "$4", "$8",
            "$5", "$10",
            "$12", "$5",
            "$7"
    };

    public String[] getAppetizerName() {
        return appetizerName;
    }

    public int[] getDrawableAppetizerId() {
        return drawableAppetizerId;
    }

    public String[] getAppetizerPrice() {
        return appetizerPrice;
    }


    // дані про десерти
    private String[] dessertsName = {
            "Belgian Waffle","Chocolate Wafers",
            "French Toast" , "Ice Cream",
            "Pancakes", "Rooty Tooty"

    };
    private int[] drawableDessertsId = {
            R.drawable.desserts_belgian_waffle, R.drawable.desserts_chocolate_wafers,
            R.drawable.desserts_french_toast, R.drawable.desserts_ice_cream,
            R.drawable.desserts_pancakes, R.drawable.desserts_rooty_tooty
    };
    private String[] dessertsPrice = {
            "$10", "$15",
            "$9", "$6",
            "$8", "$11"
    };

    public String[] getDessertsName() {
        return dessertsName;
    }

    public int[] getDrawableDessertsId() {
        return drawableDessertsId;
    }

    public String[] getDessertsPrice() {
        return dessertsPrice;
    }

    // дані про напої
private String[] beveragesName = {
        "Tea","Caramel Coffee",
        "Hot Chocolate" , "Mocha Coffee"

};
    private int[] drawableBeveragesId = {
            R.drawable.beverages_tea, R.drawable.beverages_caramel_coffee,
            R.drawable.beverages_marshmellow_hot_chocolate, R.drawable.beverages_swiss_mocha_coffee

    };
    private String[] beveragesPrice = {
            "$1", "$3",
            "$5", "$9"
    };

    public String[] getBeveragesName() {
        return beveragesName;
    }

    public int[] getDrawableBeveragesId() {
        return drawableBeveragesId;
    }

    public String[] getBeveragesPrice() {
        return beveragesPrice;
    }
}

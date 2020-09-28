# market-pricer

The aim this application is to price goods at supermarkets.
 
Some things in supermarkets have simple prices: this can of beans costs $0.65. Other things have more complex prices.
 
For example:
<ul>
<li>three for a dollar (so what’s the price if I buy 4, or 5?)</li>
<li>$1.99/pound (so what does 4 ounces cost?)</li>
<li>buy two, get one free (so does the third item have a price?)</li>
</ul>

The exercise is to experiment with a model that is flexible enough to deal with these (and other) pricing schemes, and at the same time are generally usable how do you keep an audit trail of pricing decisions.

## How to use:
Clone the project and create a Maven project from it

run `mvn clean install` to download dependencies

Once you can start the application : it will launch some product price calculation

The principal method is `MarketPricer.calculatePrice(Product product, int quantity)`

You can add more deals by implementing `Deal` interface and then implementing the method  `calculatePrice(Product product, int totalQuantity);` and everything will work for you


Enjoy ;)


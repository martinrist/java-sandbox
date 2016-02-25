@org.hibernate.annotations.NamedQueries(
        {@org.hibernate.annotations.NamedQuery(
                name = "findItemsOrderByName",
                query = "select i from Item i order by i.name asc"),
         @org.hibernate.annotations.NamedQuery(
                name = "findItemBuyNowPriceGreaterThan",
                query = "select i from Item i where i.buyNowPrice > :price",
                 timeout = 60,
                 comment = "Custom SQL comment")})

@org.hibernate.annotations.GenericGenerator(
        name = "ID_GENERATOR",
        strategy = "enhanced-sequence",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "MY_SEQUENCE"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "initial_value",
                        value = "1000"
                )
        }
)

package com.martinrist.hibernate.caveatEmptor.domain;
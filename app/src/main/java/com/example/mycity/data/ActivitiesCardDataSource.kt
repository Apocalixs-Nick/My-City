package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.ui.theme.Activity

object ActivitiesCardDataSource {
    val activities = listOf<Activity>(
        Activity(
            Title = "Centro Commerciale Campania",
            Image = R.drawable.centro_commerciale_campania,
            Description = "Il piu' bel centro commerciale",
            category = R.string.shopping_centers,
            address = "Località Aurno, 87, 81025 Marcianise CE",
            latitude = 41.00446321838611,
            longitude = 14.327885111353622
        ),
        Activity(
            Title = "Reggia di Caserta",
            Image = R.drawable.reggia_caserta,
            Description = "Il piu' bel palazzo del mondo",
            category = R.string.parks,
            address = "Piazza Carlo di Borbone, 81100 Caserta CE",
            latitude = 41.07330567786938,
            longitude = 14.327171740190835
        ),
        Activity(
            Title = "Oasi WWF San Silvestro",
            Image = R.drawable.oasi_san_silvestro,
            Description = "Un posto per stare a contatto con la natura",
            category = R.string.parks,
            address = "Via dei Giardini Reali, 78, 81100 Caserta CE",
            latitude = 41.101479526099354,
            longitude = 14.322695551839722
        ),
        Activity(
            Title = "Century Park Caserta",
            Image = R.drawable.century_parck,
            Description = "Un posto dove passare le giornate con i propri figli",
            category = R.string.kid_friendly,
            address = "Via degli Ulivi, 7, 81100 Caserta CE",
            latitude = 41.068920598341975,
            longitude = 14.358270153685107
        ),
        Activity(
            Title = "Carbone Chic",
            Image = R.drawable.carbone_caserta,
            Description = "Il luogo migliore per vestirti elagante",
            category = R.string.shopping_centers,
            address = "Via Nazionale Appia, 2, 81020 Casapulla CE",
            latitude = 41.07359239416675,
            longitude = 14.298955482520457
        ),
        Activity(
            Title = "I Masanielli di Francesco Martucci",
            Image = R.drawable.masanielli,
            Description = "Una delle migliori pizze che ci sia",
            category = R.string.restaurants,
            address = "Viale Giulio Douhet, 11, 81100 Caserta CE",
            latitude = 41.07404398076164,
            longitude = 14.318996821802331
        )
    )
}
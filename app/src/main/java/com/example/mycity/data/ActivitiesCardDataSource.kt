package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.ui.test.Activity

object ActivitiesCardDataSource {
    val activities = listOf<Activity>(
        Activity(
            Title = "Centro Commerciale Campania",
            Image = R.drawable.centro_commerciale_campania,
            Description = "Il piu' bel centro commerciale",
            category = R.string.shopping_centers,
            address = "Località Aurno, 87, 81025 Marcianise CE",
            latitude = 41.00446321838611,
            longitude = 14.327885111353622,
            link = "https://g.page/cccampania?share"
        ),
        Activity(
            Title = "Reggia di Caserta",
            Image = R.drawable.reggia_caserta,
            Description = "Il piu' bel palazzo del mondo",
            category = R.string.parks,
            address = "Piazza Carlo di Borbone, 81100 Caserta CE",
            latitude = 41.07330567786938,
            longitude = 14.327171740190835,
            link = "https://g.page/reggiadicaserta_beniculturali?share"
        ),
        Activity(
            Title = "Oasi WWF San Silvestro",
            Image = R.drawable.oasi_san_silvestro,
            Description = "Un posto per stare a contatto con la natura",
            category = R.string.parks,
            address = "Via dei Giardini Reali, 78, 81100 Caserta CE",
            latitude = 41.101479526099354,
            longitude = 14.322695551839722,
            link = "https://goo.gl/maps/voZxVKnF3vmafueWA"
        ),
        Activity(
            Title = "Century Park Caserta",
            Image = R.drawable.century_parck,
            Description = "Un posto dove passare le giornate con i propri figli",
            category = R.string.kid_friendly,
            address = "Via degli Ulivi, 7, 81100 Caserta CE",
            latitude = 41.068920598341975,
            longitude = 14.358270153685107,
            link = "https://goo.gl/maps/PFV8jNTPWBJAmS1R7"
        ),
        Activity(
            Title = "Carbone Chic",
            Image = R.drawable.carbone_caserta,
            Description = "Il luogo migliore per vestirti elagante",
            category = R.string.shopping_centers,
            address = "Via Nazionale Appia, 2, 81020 Casapulla CE",
            latitude = 41.07359239416675,
            longitude = 14.298955482520457,
            link = "https://g.page/CarboneChic?share"
        ),
        Activity(
            Title = "I Masanielli di Francesco Martucci",
            Image = R.drawable.masanielli,
            Description = "Una delle migliori pizze che ci sia",
            category = R.string.restaurants,
            address = "Viale Giulio Douhet, 11, 81100 Caserta CE",
            latitude = 41.07404398076164,
            longitude = 14.318996821802331,
            link = "https://g.page/masaniellifrancescomartucci?share"
        ),
        Activity(
            Title = "Autolinee Angelo Ferrazza & C",
            Image = R.drawable.angeloferrazza,
            Description = "La storia delle Autolinee Ferrazza è antica ed inizia agli albori del Secolo scorso con quattro fratelli, figli del signor Angelo Ferrazza, Antonio, Peppino, Michele e R.",
            category = R.string.transport,
            address = "Via Luigi Ferritto, 77, 81016 Piedimonte Matese CE",
            latitude = 41.35317203339098,
            longitude = 14.369318369201286,
            link = "https://goo.gl/maps/x6yg4F4fy678jm9v9"
        ),
        Activity(
            Title = "AIR Campania S.r.l",
            Image = R.drawable.aircampania,
            Description = "Società pubblica della Regione Campania che svolge le attività di gestione del sistema di trasporto locale urbano, regionale e provinciale.",
            category = R.string.transport,
            address = "Via Fasano Z. I. Pianodardine, 83100 Avellino",
            latitude = 40.938994855895935,
            longitude = 14.82205088465575,
            link = "https://goo.gl/maps/rKpE4dgiyTn7Gchx8"
        ),
        Activity(
            Title = "La Reggia Designer Outlet",
            Image = R.drawable.reggiaoutlet,
            Description = "L’Outlet Village di Marcianise (Caserta) “la Reggia” è un punto di riferimento in tutta la Campania per lo shopping di qualità. Il nome di questo Designer Outlet è un evidente omaggio alla Reggia di Caserta, facilmente raggiungibile dal centro, così come le principali località turistiche della provincia di Napoli.",
            category = R.string.shopping_centers,
            address = "S.P. 336 Sannitica, 81025 Marcianise CE",
            latitude = 41.006549189165995,
            longitude = 14.32137964142479,
            link = "https://goo.gl/maps/N5jX4Dyud27C3Bg8A"
        ),
        Activity(
            Title = "Caffetteria del Corso",
            Image = R.drawable.caffecorso,
            Description = "Con più di 40 anni di attività di produzione familiare.",
            category = R.string.coffe_shops,
            address = "Via Roma ,127, Aversa, Italy",
            latitude = 40.97225233557485,
            longitude = 14.207918569311522,
            link = "https://g.page/caffetteriadelcorso-aversa?share"
        ),
        Activity(
            Title = "Il Buco Lounge Bar",
            Image = R.drawable.buco,
            Description = "Ubicato in uno dei vicoli più caratteristici del centro storico di Caiazzo.",
            category = R.string.coffe_shops,
            address = "Vicolo S. Giovanni Battista, 81013 Caiazzo CE",
            latitude = 41.17805061635622,
            longitude = 14.366004738636827,
            link = "https://goo.gl/maps/Mp3GcVrvUARXVo3XA"
        )
    )
}
# Zadání projektu TopGun - 1. pololetí
------------------------------------

Dědičnost a polymorfizmus

1.  Realizujte za využití OOP konzolový základ RPG soubojového a inventářového systému. Požadované třídy:

-   Base.Character (postava)
-   Items.Weapon (zbraň)
-   Items.Shield (štít)
-   Items.Armor (brnění)
-   Copper, Silver, Gold (druhy mincí)

Přesná implementace je na vás, můžete (a dává to smysl) přidat další třídy, statické metody apod., vyžadováno je toto chování:

-   Každá postava má jméno, sílu, obratnost, maximální HP, inventář a nosnost

-   V konstruktoru se předává jméno, další hodnoty se generují s použitím náhody/hodu kostkou, MaxHP se odvíjí od odolnosti

-   Každý předmět má vlastní název a hmotnost. Každý předmět lze vložit do inventáře. Postava ale nemůže (kód to nikdy nepřipustí) dát do inventáře nebo vzít do ruky předmět, který neunese (celková hmotnost vs. nosnost)
-   Zbraně mají nějakou hodnotu Attack a Damage, brnění a štíty jejich obranný ekvivalent.
-   Postava může mít v rukou buď obouruční zbraň, jednoruční zbraň a štít, nebo jen jednoruční zbraň, na sobě může a nemusí mít brnění

-   V kombinaci s vlastnostmi postavy (síla, obratnost) dávají zbraně a štíty náhodný hod na útok a obranu a z nich vychází, zda a jak byla postava zraněna (udělejte postavě vhodné metody pro útok na někoho a obranu proti útoku. Automaticky se použijí brnění, které má na sobě, a to, co drží v rukou). Konkrétní herní mechanizmus si navrhněte sami

-   Postava umí udělat výpis inventáře ("*Golden Items.Shield +1, Red coat, Silver necklace*")

-   Některé typy vybavení jsou stohovatelné (stackovatelné), tzn. ve výpisu budou shluknuty, např. "*Gold Coin (12)*". Musí je ale být možné vložit do inventáře stejně tak jako zbraň, jídlo nebo cokoli jiného.

-   Postava má vlastnost, která odpoví, kolik peněz má u sebe celkem v měďácích (10 copper = 1 silver, 10 silver = 1 gold)

Vytvořte ještě alespoň jednu další třídu pro stohovatelné  předměty a jednu pro nestohovatelné dle vlastní fantazie (s nějakou charakteristickou metodou - třeba u dopisu "přečti" apod). Mělo by také být možné vložit do inventáře i "obecný" předmět, který nemá nic než název a hmotnost

Navrhněte dobře strukturu tříd v hierarchii dědičnosti tak, aby se kód zbytečně neopakoval, byl dobře umístěn a využíval polymorfní chování. Rozmyslete, zda by některé třídy neměly být abstraktní. Nevystavujte navenek žádné zbytečné veřejné metody, používejte správně příznaky "chráněné" a "soukromé".

1.  Napište program, který inicializuje dvě postavy včetně zbraní atd. s využitím dříve napsaných tříd. Program předvede funkčnost vytvořených tříd a metod - nejprve ukáže, co se děje (beru meč, nelze - je moc těžký ,...), vypíše inventář apod. Pak spustí souboj mezi oběma postavami s výpisem děje (*něco jako Brum útočí (13/+2), Chrocht se brání (7), zásah za 7 HP, zbývá 30 HP ...  ... ... Brum umírá, Chrocht vítězí*)

1.  Vytvořte k veřejným metodám všech tříd Unit testy tak, aby testovaly správné chování včetně správných chybových stavů (pokus o vyzbrojení příliš těžkým mečem apod.), pokud budete používat výjimky, nezapomeňte testovat i jejich vyvolávání.

1.  Projektu vytvořte veřejný repozitář na GitHubu, link na něj odevzdejte\
    *Poznámka: Cílem tohoto projektu je osvojit si/prokázat znalost a používání metod OOP pro organizaci kódu. Prosím pokuste se jej řešit "co nejvíc OOP", nikoli OOP maximálně obcházet.*
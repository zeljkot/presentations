# Agilna procjena i planiranje
# <BR>
## Stanislav Strešnjak 
## Željko Trogrlić
Note:
Kao u američkom nogometu, četiri četvrtine
---
# Planiranje
Note:
Prebacivanje rokova
* Skrpan software
* Loše završen shopping centar
* Mobilni uređaji s problemima
---


# Specificiranje zahtjeva


---
# Old school
1. Kupac: zahtjevi
1. Ekspertni tim: zadaci (opis i trajanje)
1. Razvojni tim: izvedba
* Razvojni tim ne osjeća odgovornost i ne razumije zadatke
---
# Korisničke priče
* Korisnički zahtjevi visokog nivoa
* Poslovne potrebe
* Tim sudjeluje u definiciji i procjeni
---
# Korisničke priče: format
> Kao *uloga*, želim *funkcija* tako da *vrijednost*

+++
Primjeri:
* Kao *kupac*, želim *moći resetirati svoju zaporku* tako da *se mogu prijaviti i ako je izgubim*
* Kao *korisnik mobitela*, želim *ga moći brzo utišati* tako da *mi ne zvoni kad odem kod liječnika ili u kino*
* Kako *vlasnik automobila*, želim *moći brzo i bez posebnog alata promijeniti sijalice* tako da *mogu brzo nastaviti voziti ako pregore*
Note:
Želimo Google Maps!
---
# Elementi dobre korisničke priče (EN)
* **I**ndependent
* **N**egotiable
* **V**aluable
* **E**stimable
* **S**mall (3-4 dana, <sprint)
* **T**estable
Note:
Testable - virtualni razgovor - dokaži!
---
# Elementi dobre korisničke priče (HR)
* **N**eovisna
* **P**regovorljiva
* **V**rijedna
* **P**rocjenljiva
* **M**ala
* **P**rovjerljiva
Note:
Zaključak: u hrvatskom previše riječi počinje sa zatvornikom.
---
# Značajke dobrog zadatka
* **S**pecific
* **M**easurable
* **A**chievable
* **R**elevant
* **T**ime-Boxed
---
# Određivanje redoslijeda korisnih priča
* Grupiranje u teme
* Parametri
  * Poslovna vrijednost
  * Tehnička kompleksnost
  * Stjecanje znanja
  * Uklanjanje rizika
+++
# Poslovno ocjenjivanje
* Zarada
* Ušteda
+++
# Tehnička kompleksnost
* Cijena razvoja kroz story pointe
+++
# Stjecanje znanja
* Što (analiza)
* Kako (dizajn)
* Waterfall: što pa kako
* Agile: što i kako paralelno
+++
# Kombinirano ocjenjivanje
<canvas data-chart="scatter">
<!-- 
{
  "data": {
    "datasets": [{
      "label": "Points",
      "data":
        [
          {"x": randomScalingFactor(), "y": randomScalingFactor()},
          {"x": randomScalingFactor(), "y": randomScalingFactor()},
          {"x": randomScalingFactor(), "y": randomScalingFactor()},
          {"x": randomScalingFactor(), "y": randomScalingFactor()}
        ]
    }]
  },
  "options": { 
    "label": "My Label",
    scales: {
      xAxes: [{
        display: true,
        scaleLabel: {
          display: true,
          labelString: 'Poslovna vrijednost'
        }
      }],
      yAxes: [{
        display: true,
        scaleLabel: {
          display: true,
          labelString: 'Rizik'
        }
      }]
    }
  }
}
-->
</canvas>
---


# Metoda agilne procjene
# Planiranje sprinta


---
# Metoda agilne procjene
* Mudrost mnoštva
* Delphi i Wideband Delphi
* Agilni poker
+++
# Mudrost mnoštva
* Procjena težine vola
* Plymouth, 1906
* Stručnjaci protiv mnoštva
+++
# Delphi i Wideband Delphi
* Delphi: 1950-1960, hladni rat, RAND Corporation
  * Ciklusi prezentiranja i ocjenjivanja
* Wideband Delphi: više komunikacije
Note:
Dr. Strangelove, 1964.: Stanley Kubrick an Peter Sellers
+++
# Agilni poker
* Inačica Wideband Delphia
* Karte s Fibonaccievim nizom
* Veće procjene imaju veću pogrešku
---
# Mjerne jedinice
* Story points
* Idealni (programerski) dani

Note:
Meni treba toliko, tebi toliko
---

# Planiranje Sprinta


Note:
Stanislav
---
# Značajke dobrog zadatka
* **S**pecific
* **M**easurable
* **A**chievable
* **R**elevant
* **T**ime-Boxed
---
# Odabir priča
# Postavljanje cilja
---


# Praćenje napretka
# Planiranje releasea
# Skalabilnost


---
# Praćenje napretka
---
# Kanban elementi (ploča, ograničavanje posla)
---
# Burndown grafikoni
---
# Planiranje inačica
---
# Skalabilnost
* Fraktalna organizacija
    * Scrum scrumova
* SAFe 4.5
* Agile Portfolio Management (APM)
* Large Scale Scrum (LeSS)
* Disciplined Agile (DA, ex DAD)

Note:
Version One State of Agile 2017
Za posjetitelje Version One stranice Version One je najbolji.
---
# Zastupljenost
<canvas data-chart="pie">
<!-- 
{
  "data": {
    "labels": ["SAFe 4.5", "Scrum scrumova", "Agile Portfolio Management (APM)", "Interne metode", "Lean Management", "Large Scale Scrum (LeSS)", "Disciplined Agile (DA)", "RAGE", "Nexus"],
    "datasets": [
      {
        "data":[28, 27, 13, 4, 4, 3, 1, 1, 1]
      }
    ]
  }, 
  "options": { "responsive": "true" }
}
-->
</canvas>
---
# Scrum scrumova
* Vurtualni nad-tim
* Daily sastavljen od predstavnika timova
  * nakon timskog dailya
  * scrum master, ostali po potrebi
* Scrum scrumova master odgovoran za isporuku
* Meta scrum: PO tim
* Executive Action Team (EAT): menadžerski tim

Note:
Mr. Milan Sijerković: Scrum scrumova -  Bog bogova!
---
# SAFe 4.5
* Portfolio
* Value Train
* Program
* Team

Note:
Value Train = Solution roles
Team = Scrum
---
# Team
* 2 week sprint
# Program - roles
* Roles 
  * Agile Release Train (ART)
    * Multiple teams
    * 50-125 people
  * Release Train Engineer = Scrum Master
  * Program manager = Scrum Master
  * System architect: makes architectural runway
# Program - Process
  * Program increment (PI) = 5 iterations
  * Scrum of scrums every 2 weeks
  * System demo every 2 weeks
  * Last week - innovation and planning (IP)  
  * Planning meeting (vision + planning)
# Program - Artifacts
  * Features = user stories
  * Program board = Scrum Board
---
# Za ponijeti doma
---
#
# Hvala

---
# Rezervni
---
# LeSS
* Do 8 timova x 8 članova
* Jedan:
  * Backlog
  * Definicija gotovog
  * Proizvod
  * Owner
  * Sprint
* Dva planiranja sprinta
---

# Search Google Flight

Automation that searches flights from Google Flights and emails a screenshot of the results using the user's parameters.



## Running the tests

Sample command for running the automation

```
gradle clean test -Dgroup=flight -Denv=local -Dorigin=Boston -Ddestination='Las Vegas' -DdepartureDate=02/15/2019 -DreturnDate=02/24/2019 -DnumberAdults=1 -DnumberChildren=0 -DnumberInfantsInSeat=0 -DnumberInfantsOnLap=0 -DemailRecipient=test@yopmail.com 
```

### Parameters

Required command parameters
```
-Dgroup=flight
-Denv=(local or environment)
-Dorigin=
-Ddestination=
-DdepartureDate=
-DreturnDate= (leave blank for one way flight)
-DnumberAdults=1 (minimum 1)
-DnumberChildren=0 
-DnumberInfantsInSeat=0 
-DnumberInfantsOnLap=0 
-DemailRecipient=

```

## Authors

* **James Santiago** - [jjamzz](https://github.com/jjamzz)


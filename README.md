
# Sepatype

This program takes numbers from stdin and prints the english word representation of the number.
## Getting Started


### Prerequisites

* Java 8
* Internet connection accessible to Jcenter

### Running

To run the program:

```
./gradlew run
```

Then input your numbers:
```
>123123123123123
The word value for : 123123123123123 is: One Hundred Twenty Three Trillion One Hundred Twenty Three Billion One Hundred Twenty Three Million One Hundred Twenty Three Thousand One Hundred Twenty Three

```

## Input criteria

 - No non-numeric characters other than comma: "," and negative sign: "-"
 - No whitespace
 - input >= -9223372036854775808
 - input <= 9223372036854775807

## Running the tests


To run the unit tests:
```
./gradlew test
```



## Built With

* Gradle
* Java 11
* Junit 4
* IntellJ IDEA CE


## TODO
* Implement lookup for repeat values
* Component tests
* Refactor unit tests to export test values into resources

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

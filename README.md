# Searcher

Searcher is a simple ​command​ ​line​ ​text​ ​search​ ​engine, capable of finding words in text files.

## Run

You can run the included JAR to search content of `test-files` directory:

```bash
java -jar Searcher-0.1.jar test-files/
```

Or alternatively run the application using SBT:

```bash
sbt "run test-files/"
```

## Usage

You can then search the loaded files for words (they will be converted to lowercase):

```bash
search> to be or not to be
```

If the search terms are found in the indexed files, a sorted list of files will be returned to the user:

```bash
file1.txt​ ​:​ ​100%
file2.txt : 50%
```

## Tests

You can run the unit tests using SBT:

```bash
sbt test
```

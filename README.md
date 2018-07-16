# Searcher

Searcher is a simple ​command​ ​line​ ​text​ ​search​ ​engine, capable of finding words in text files.

## Usage

Run the application using SBT:

```bash
sbt "run /foo/bar"
```

For example:

```bash
sbt "run test-files/"
```

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

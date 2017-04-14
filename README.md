Auto-Complete Application
=========================
Assignmnet from of Princeton University's Algorithms and Data Structures course, to implement [Auto-Complete](https://www.cs.princeton.edu/courses/archive/fall14/cos226/assignments/autocomplete.html) application using Maven.
Given a set of N strings and positive weights. and for a given prefix, automcomplete program will find all strings in the set that start with the prefix, in descending order of weight.


Performance requirements
------------------------
 * The firstIndexOf() and lastIndexOf() methods should make at most 1 + [log2 N] compares in the worst case
 * The allMatches() method should make proportional to log N + M log M compares (or better) in the worst case, where M is the number of matching terms. 
 * The numberOfMatches() method should make proportional to log N compares (or better) in the worst case. In this context, a compare is one call to any of the compare() or compareTo() methods defined in Term.
 
 
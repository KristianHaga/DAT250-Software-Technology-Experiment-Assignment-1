# Assignment 4

## Installation

### Derby

Struggled for some with the installation. I felt like the Derby tutorial could've been a bit better explained, because it took me way longer that it should have to get it up and running. 

### JPA

I also struggled with the setup of a JPA application. I kept getting vague errors refering to my `persistence.xml` file. My problem seemed to be solved by switching `EclipseLink` versions from `2.6.7` using `javax.persistence` to the `2.7.7` version using `Jakarta.persistence`.

After the many initial hurdles, the rest of the assignment went very smoothly. 

## Link to my Java projects

### Experiment 1

[de.vogella.jpa.simple](https://github.com/KristianHaga/DAT250-Software-Technology-Experiment-Assignment-2/tree/master/de.vogella.jpa.simple)

[de.vogella.jpa.eclipselink](https://github.com/KristianHaga/DAT250-Software-Technology-Experiment-Assignment-2/tree/master/de.vogella.jpa.eclipselink)


### Experiment 2

[BankingExample](https://github.com/KristianHaga/DAT250-Software-Technology-Experiment-Assignment-2/tree/master/BankingExample)

## Inspecting the Derby Database

I accessed the database using the `Derby ij tools` in the terminal. First connecting to the created database using the username and password specified in the `persistence.xml` file. And then using the built-in commands such as lising the tables and sending in simple SQL-queries to return the contents of the table. 

I also printed some of the returned values from the query in the `BankingExample`. This felt like a more cumbersome approach. 

## Pending issues

I think i manged to solve all tasks by the end. Hopefully they were also solved correctly. 


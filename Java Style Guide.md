# Java Style Guide

## Table of Contents

1. [Introduction](#1)  
[1.1 Terminology notes](#1.1)  
[1.2 Guide notes](#1.2)  
2. [Source file basics](#2)  
[2.1 File name](#2.1)  
[2.2 File encoding: UTF-8](#2.2)  
[2.3 Special characters](#2.3)  
3. [Source file structure](#3)  
[3.1 License or copyright information, if presen](#3.1)  
[3.2 Package statement](#3.2)  
[3.3 Import statements](#3.3)  
[3.4 Class declaration](#3.4)  
4. [Formatting](#4)  
[4.1 Braces  ](#4.1)  
[4.2 Block indentation: +2 spaces](#4.2)  
[4.3 One statement per line](#4.3)  
[4.4 Column limit: 100](#4.4)  
[4.5 Line-wrapping](#4.5)  
[4.6 Whitespace](#4.6)  
[4.7 Grouping parentheses: recommended](#4.7)  
[4.8 Specific constructs](#4.8)  
5. [Naming](#5)  
[5.1 Rules common to all identifiers](#5.1)  
[5.2 Rules by identifier type](#5.2)  
[5.3 Camel case: defined](#5.3)  
6. [Programming Practices](#6)  
[6.1 @Override: always used](#6.1)  
[6.2 Caught exceptions: not ignored](#6.2)  
[6.3 Static members: qualified using class](#6.3)  
[6.4 Constructs to Avoid](#6.4)  
[6.5 Do Not Compound Increment or Decrement Operators](#6.5)
[6.6 Access](#6.6)
7. [Javadoc](#7)  
[7.1 Self-Documenting Code](#7.1)
[7.2 Formatting](#7.2)  
[7.3 The summary fragment](#7.3)  
[7.4 Where Javadoc is use](#7.4)  
8. [Reference](#8)

## <span id="1">1 Introduction</span>

This document serves as the **complete** definition of Google's coding standards for source code in the Javaâ„¢ Programming Language. A Java source file is described as being <i>in Google Style</i> if and only if it adheres to the rules herein.

Like other programming style guides, the issues covered span not only aesthetic issues of formatting, but other types of conventions or coding standards as well. However, this  focuses primarily on the **hard-and-fast** rules that we follow universally, and avoids giving advice that isn't clearly enforceable (whether by human or tool).

### <span id="1.1">1.1 Terminology notes</span>

In this document, unless otherwise clarified:

1. The term <i>**class**</i> is used inclusively to mean an "ordinary" class, enum class, interface or annotation type (```@interface```).
2. The term <i>**member**</i> (of a class) is used inclusively to mean a nested class, field, method, or constructor; that is, all top-level contents of a class except initializers and comments.
3. The term <i>**comment**</i> always refers to implementation comments. We do not use the phrase "documentation comments", instead using the common term "Javadoc."  

Other "terminology notes" will appear occasionally throughout the document.

### <span id="1.2">1.2 Guide Notes</span>

Example code in this document is **non-normative**. That is, while the examples are in Google Style, they may not illustrate the only stylish way to represent the code. Optional formatting choices made in examples should not be enforced as rules.

## <span id="2">2 Source file basics</span>

### <span id="2.1">2.1 File name</span>

The source file name consists of the case-sensitive name of the top-level class it contains (of which there is exactly one), plus the ```.java``` extension.

### <span id="2.2">2.2 File encoding: UTF-8</span>

Source files are encoded in **UTF-8**.

### <span id="2.3">2.3 Special characters</span>

#### <span id="2.3.1">2.3.1 Whitespace characters</span>

Aside from the line terminator sequence, the **ASCII horizontal space character (0x20)** is the only whitespace character that appears anywhere in a source file. This implies that:

1. All other whitespace characters in string and character literals are escaped.
2. Tab characters are **not** used for indentation.

#### <span id="2.3.2">2.3.2 Special escape sequences</span>

For any character that has a special escape sequence (```\b```, ```\t```, ```\n```, ```\f```, ```\r```, ```\"```, ```\'``` and ```\\```), that sequence is used rather than the corresponding octal (e.g. ```\012```) or Unicode (e.g. ```\u000a```) escape.

#### <span id="2.3.3">2.3.3 Non-ASCII characters</span>

For the remaining non-ASCII characters, either the actual Unicode character (e.g. `∞`) or the equivalent Unicode escape (e.g. `\u221e`) is used. The choice depends only on which makes the code **easier to read and understand**, although Unicode escapes outside string literals and comments are strongly discouraged.

>**Tip:** In the Unicode escape case, and occasionally even when actual Unicode characters are used, an explanatory comment can be very helpful.

Examples:

|Tables|Discussion|
|:------------------------------------------------------------|:----------------------------------------------------------------------------------|
|```String unitAbbrev = "μs";```                              |Best: perfectly clear even without a comment.|
|```String unitAbbrev = "\u03bcs"; // "μs"```                 |Allowed, but there's no reason to do this.|
|```String unitAbbrev = "\u03bcs"; // Greek letter mu, "s"``` |Allowed, but awkward and prone to mistakes.|
|```String unitAbbrev = "\u03bcs";```                         |Poor: the reader has no idea what this is.|
|```return '\ufeff' + content; // byte order mark```          |Good: use escapes for non-printable characters, and comment if necessary.|

>**Tip:** Never make your code less readable simply out of fear that some programs might not handle non-ASCII characters properly. If that should happen, those programs are **broken** and they must be **fixed**.

## <span id="3">3 Source file structure</span>

A source file consists of, **in order**:

1. License or copyright information, if present
2. Package statement
3. Import statements
4. Exactly one top-level class

**Exactly one blank line** separates each section that is present.

### <span id="3.1">3.1 License or copyright information, if present</span>

If license or copyright information belongs in a file, it belongs here.

### <span id="3.2">3.2 Package statement</span>

The package statement is **not line-wrapped**.

### <span id="3.3">3.3 Import statements</span>

#### <span id="3.3.1">3.3.1 No wildcard imports</span>

Wildcard imports are not used.

#### <span id="3.3.2">3.3.2 No line-wrapping</span>

Import statements are **not line-wrapped**.

#### <span id="3.3.3">3.3.3 Ordering and spacing</span>

Imports are ordered as follows:

1. All static imports in a single block.
2. All non-static imports in a single block.

If there are both static and non-static imports, a single blank line separates the two blocks. There are no other blank lines between import statements.

Within each block the imported **names** appear in ASCII sort order.

#### <span id="3.3.4">3.3.4 No static import for classes</span>

Static import is not used for static nested classes. They are imported with normal imports.

### <span id="3.4">3.4 Class declaration</span>

#### <span id="3.4.1">3.4.1 Exactly one top-level class declaration</span>

Each top-level class resides in a source file of its own.

#### <span id="3.4.2">3.4.2 Ordering of class contents</span>

The order you choose for the members and initializers of your class should be **logical**, which means its maintainer could give an explanation if asked. (chronological order is not recommended)

Also, when a class has multiple constructors, or multiple methods with the same name, these appear sequentially, with no other code in between.

## <span id="4">4 Formatting</span>

**Terminology Note:** *block-like construct* refers to the body of a class, method or constructor. Note that, by Section 4.8.3.1 on [array initializers](#4.8.3.1), any array initializer *may* optionally be treated as if it were a block-like construct.

### <span id="4.1">4.1 Braces</span>

#### <span id="4.1.1">4.1.1 Braces are used where optional</span>

Braces are used with ```if```, ```else```, `for`, `do` and `while` statements, even when the body is empty or contains only a single statement.

#### <span id="4.1.2">4.1.2 Nonempty blocks: K & R style</span>

Braces follow the Kernighan and Ritchie style ("[Egyptian brackets](http://www.codinghorror.com/blog/2012/07/new-programming-jargon.html)") for *nonempty* blocks and block-like constructs:

- No line break before the opening brace.
- Line break after the opening brace.
- Line break before the closing brace.
- Line break after the closing brace, *only if* that brace terminates a statement or terminates the body of a method, constructor, or *named* class. For example, there is *no* line break after the brace if it is followed by `else` or a comma.

Examples:

```java
return () -> {
  while (condition()) {
    method();
  }
};

return new MyClass() {
  @Override public void method() {
    if (condition()) {
      try {
        something();
      } catch (ProblemException e) {
        recover();
      }
    } else if (otherCondition()) {
      somethingElse();
    } else {
      lastThing();
    }
  }
};
```

A few exceptions for enum classes are given in Section 4.8.1, [Enum classes](#4.8.1).

#### <span id="4.1.3">4.1.3 Empty blocks: may be concise</span>

An empty block or block-like construct may be in K & R style (as described in [Section 4.1.2](#4.1.2)). Alternatively, it may be closed immediately after it is opened, with no characters or line break in between (`{}`), **unless** it is part of a *multi-block statement* (one that directly contains multiple blocks: `if/else` or `try/catch/finally`).

Examples:

```java
  // This is acceptable
  void doNothing() {}
```

```java
  // This is equally acceptable
  void doNothingElse() {
  }
  // This is not acceptable: No concise empty blocks in a multi-block statement
  try {
    doSomething();
  } catch (Exception e) {}
```

### <span id="4.2">4.2 Block indentation: +2 spaces</span>

Each time a new block or block-like construct is opened, the indent increases by two spaces. When the block ends, the indent returns to the previous indent level. The indent level applies to both code and comments throughout the block. (See the example in Section 4.1.2, [Nonempty blocks: K & R Style](#4.1.2).)

### <span id="4.3">4.3 One statement per line</span>

Each statement is followed by a line break.

### <span id="4.4">4.4 Column limit: 100</span>

Java code has a column limit of 100 characters. A "character" means any Unicode code point. Except as noted below, any line that would exceed this limit must be line-wrapped, as explained in Section 4.5, [Line-wrapping](#4.5).

Each Unicode code point counts as one character, even if its display width is greater or less. For example, if using [fullwidth characters](https://en.wikipedia.org/wiki/Halfwidth_and_fullwidth_forms), you may choose to wrap the line earlier than where this rule strictly requires.

**Exceptions:**

1. Lines where obeying the column limit is not possible (for example, a long URL in Javadoc, or a long JSNI method reference).
2. `package` and `import` statements (see Sections 3.2 [Package statement](#3.2) and 3.3 [Import statements](#3.3).
3. Command lines in a comment that may be cut-and-pasted into a shell.

### <span id="4.5">4.5 Line-wrapping</span>

**Terminology Note:** When code that might otherwise legally occupy a single line is divided into multiple lines, this activity is called *line-wrapping*.

There is no comprehensive, deterministic formula showing *exactly* how to line-wrap in every situation. Very often there are several valid ways to line-wrap the same piece of code.

**Note:** While the typical reason for line-wrapping is to avoid overflowing the column limit, even code that would in fact fit within the column limit *may* be line-wrapped at the author's discretion.

**Tip:** Extracting a method or local variable may solve the problem without the need to line-wrap.

#### <span id="4.5.1">4.5.1 Where to break</span>

The prime directive of line-wrapping is: prefer to break at a **higher syntactic level**. Also:

1. When a line is broken at a <i>non-assignment</i> operator the break comes <i>before</i> the symbol. (Note that this is not the same practice used in Google style for other languages, such as C++ and JavaScript.)

   - This also applies to the following "operator-like" symbols:
     - the dot separator (`.`)
     - the two colons of a method reference (`::`)
     - an ampersand in a type bound (`<T extends Foo & Bar>`)
     - a pipe in a catch block (`catch (FooException | BarException e)`).

2. When a line is broken at an <i>assignment</i> operator the break typically comes <i>after</i> the symbol, but either way is acceptable.

   - This also applies to the "assignment-operator-like" colon in an enhanced `for` ("foreach") statement.

3. A method or constructor name stays attached to the open parenthesis (`(`) that follows it.
4. A comma (`,`) stays attached to the token that precedes it.
5. A line is never broken adjacent to the arrow in a lambda, except that a break may come immediately after the arrow if the body of the lambda consists of a single unbraced expression. Examples:

```java
MyLambda<String, Long, Object> lambda =
    (String label, Long value, Object obj) -> {
        ...
    };

Predicate<String> predicate = str ->
    longExpressionInvolving(str);
```

>**Note:** The primary goal for line wrapping is to have clear code, *not necessarily* code that fits in the smallest number of lines.

#### <span id="4.5.2">4.5.2 Indent continuation lines at least +4 spaces</span>

When line-wrapping, each line after the first (each *continuation line*) is indented at least +4 from the original line.

When there are multiple continuation lines, indentation may be varied beyond +4 as desired. In general, two continuation lines use the same indentation level if and only if they begin with syntactically parallel elements.

Section 4.6.3 on [Horizontal alignment](#4.6.3) addresses the discouraged practice of using a variable number of spaces to align certain tokens with previous lines.

### <span id="4.6">4.6 Whitespace</span>

#### <span id="4.6.1">4.6.1 Vertical Whitespace</span>

A single blank line always appears:

1. <i>Between</i> consecutive members or initializers of a class: fields, constructors, methods, nested classes, static initializers, and instance initializers.

   - **Exception:** A blank line between two consecutive fields (having no other code between them) is optional. Such blank lines are used as needed to create *logical groupings* of fields.
   - **Exception:** Blank lines between enum constants are covered in [Section 4.8.1](#4.8.1).

2. As required by other sections of this document (such as Section 3, [Source file structure](#3), and Section 3.3, [Import statements](#3.3)).

A single blank line may also appear anywhere it improves readability, for example between statements to organize the code into logical subsections. A blank line before the first member or initializer, or after the last member or initializer of the class, is neither encouraged nor discouraged.

*Multiple* consecutive blank lines are permitted, but never required (or encouraged).

#### <span id="4.6.2">4.6.2 Horizontal whitespace</span>

Beyond where required by the language or other style rules, and apart from literals, comments and Javadoc, a single ASCII space also appears in the following places **only**.

1. Separating any reserved word, such as `if`, `for` or `catch`, from an open parenthesis (`(`) that follows it on that line

2. Separating any reserved word, such as `else` or `catch`, from a closing curly brace (`}`) that precedes it on that line

3. Before any open curly brace (`{`}), with two exceptions:

   - `@SomeAnnotation({a, b})` (no space is used)
   - `String[][] x = {{"foo"}};` (no space is required between `{{`, by item 8 below)

4. On both sides of any binary or ternary operator. This also applies to the following "operator-like" symbols:

   - the ampersand in a conjunctive type bound: `<T extends Foo & Bar>`
   - the pipe for a catch block that handles multiple exceptions: `catch (FooException | BarException e)`
   - the colon (`:`) in an enhanced `for` ("foreach") statement
   - the arrow in a lambda expression: `(String str) -> str.length()`

   but not

   - the two colons (`::`) of a method reference, which is written like `Object::toString`
   - the dot separator (`.`), which is written like `object.toString()`

5. After `,:;` or the closing parenthesis (`)`) of a cast

6. On both sides of the double slash (`//`) that begins an end-of-line comment. Here, multiple spaces are allowed, but not required.

7. Between the type and variable of a declaration: `List<String> list`

8. Optional



   just inside both braces of an array initializer

   - `new int[] {5, 6}` and `new int[] { 5, 6 }` are both valid

9. Between a type annotation and `[]` or `...`.

This rule is never interpreted as requiring or forbidding additional space at the start or end of a line; it addresses only *interior* space.

#### <span id="4.6.3">4.6.3 Horizontal alignment: never required</span>

**Terminology Note:** *Horizontal alignment* is the practice of adding a variable number of additional spaces in your code with the goal of making certain tokens appear directly below certain other tokens on previous lines.

This practice is permitted, but is **never required** by Google Style. It is not even required to *maintain* horizontal alignment in places where it was already used.

Here is an example without alignment, then using alignment:

```java
private int x; // this is fine
private Color color; // this too

private int   x;      // permitted, but future edits
private Color color;  // may leave it unaligned
```

>**Tip:** Alignment can aid readability, but it creates problems for future maintenance. Consider a future change that needs to touch just one line. This change may leave the formerly-pleasing formatting mangled, and that is **allowed**. More often it prompts the coder (perhaps you) to adjust whitespace on nearby lines as well, possibly triggering a cascading series of reformattings. That one-line change now has a "blast radius." This can at worst result in pointless busywork, but at best it still corrupts version history information, slows down reviewers and exacerbates merge conflicts.

### <span id="4.7">4.7 Grouping parentheses: recommended</span>

Optional grouping parentheses are omitted only when author and reviewer agree that there is no reasonable chance the code will be misinterpreted without them, nor would they have made the code easier to read. It is *not* reasonable to assume that every reader has the entire Java operator precedence table memorized.

### <span id="4.8">4.8 Specific constructs</span>

#### <span id="4.8.1">4.8.1 Enum classes</span>

After each comma that follows an enum constant, a line break is optional. Additional blank lines (usually just one) are also allowed. This is one possibility:

```java
private enum Answer {
  YES {
    @Override public String toString() {
      return "yes";
    }
  },

  NO,
  MAYBE
}
```

An enum class with no methods and no documentation on its constants may optionally be formatted as if it were an array initializer (see Section 4.8.3.1 on [array initializers](https://google.github.io/styleguide/javaguide.html#s4.8.3.1-array-initializers)).

```java
private enum Suit { CLUBS, HEARTS, SPADES, DIAMONDS }
```

Since enum classes *are classes*, all other rules for formatting classes apply.





#### <span id="4.8.2">4.8.2 Variable declarations</span>

##### <span id="4.8.2.1">4.8.2.1 One variable per declaration</span>

Every variable declaration (field or local) declares only one variable: declarations such as `int a, b;` are not used.

**Exception:** Multiple variable declarations are acceptable in the header of a `for` loop.

##### <span id="4.8.2.2">4.8.2.2 Declared when needed</span>

Local variables are **not** habitually declared at the start of their containing block or block-like construct. Instead, local variables are declared close to the point they are first used (within reason), to minimize their scope. Local variable declarations typically have initializers, or are initialized immediately after declaration.

#### <span id="4.8.3">4.8.3 Arrays</span>

##### <span id="4.8.3.1">4.8.3.1 Array initializers: can be "block-like"</span>

Any array initializer may *optionally* be formatted as if it were a "block-like construct." For example, the following are all valid (**not** an exhaustive list):

```java
new int[] {           new int[] {
  0, 1, 2, 3            0,
}                       1,
                        2,
new int[] {             3,
  0, 1,               }
  2, 3
}                     new int[]
                          {0, 1, 2, 3}
```

##### <span id="4.8.3.2">4.8.3.2 No C-style array declarations</span>

The square brackets form a part of the *type*, not the variable: `String[] args`, not `String args[]`.

#### <span id="4.8.4">4.8.4 Switch statements</span>

**Terminology Note:** Inside the braces of a *switch block* are one or more *statement groups*. Each statement group consists of one or more *switch labels* (either `case FOO:` or `default:`), followed by one or more statements (or, for the *last* statement group, *zero* or more statements).

##### <span id="4.8.4.1">4.8.4.1 Indentation</span>

As with any other block, the contents of a switch block are indented +2.

After a switch label, there is a line break, and the indentation level is increased +2, exactly as if a block were being opened. The following switch label returns to the previous indentation level, as if a block had been closed.

##### <span id="4.8.4.2">4.8.4.2 Fall-through: commented</span>

Within a switch block, each statement group either terminates abruptly (with a `break`, `continue`, `return` or thrown exception), or is marked with a comment to indicate that execution will or *might* continue into the next statement group. Any comment that communicates the idea of fall-through is sufficient (typically `// fall through`). This special comment is not required in the last statement group of the switch block. Example:

```java
switch (input) {
  case 1:
  case 2:
    prepareOneOrTwo();
    // fall through
  case 3:
    handleOneTwoOrThree();
    break;
  default:
    handleLargeNumber(input);
}
```

Notice that no comment is needed after `case 1:`, only at the end of the statement group.

##### <span id="4.8.4.3">4.8.4.3 The `default` case is present</span>

Each switch statement includes a `default` statement group, even if it contains no code.

**Exception:** A switch statement for an `enum` type *may* omit the `default` statement group, *if* it includes explicit cases covering *all* possible values of that type. This enables IDEs or other static analysis tools to issue a warning if any cases were missed.

#### <span id="4.8.5">4.8.5 Annotations</span>

Annotations applying to a class, method or constructor appear immediately after the documentation block, and each annotation is listed on a line of its own (that is, one annotation per line). These line breaks do not constitute line-wrapping (Section 4.5, [Line-wrapping](#4.5)), so the indentation level is not increased. Example:

```java
@Override
@Nullable
public String getNameIfPresent() { ... }
```

**Exception:** A *single* parameterless annotation *may* instead appear together with the first line of the signature, for example:

```java
@Override public int hashCode() { ... }
```

Annotations applying to a field also appear immediately after the documentation block, but in this case, *multiple* annotations (possibly parameterized) may be listed on the same line; for example:

```java
@Partial @Mock DataLoader loader;
```

There are no specific rules for formatting annotations on parameters, local variables, or types.

#### <span id="4.8.6">4.8.6 Comments</span>

This section addresses *implementation comments*. Javadoc is addressed separately in Section 7, [Javadoc](#7).

Any line break may be preceded by arbitrary whitespace followed by an implementation comment. Such a comment renders the line non-blank.

##### <span id="4.8.6.1">4.8.6.1 Block comment style</span>

Block comments are indented at the same level as the surrounding code. They may be in `/* ... */` style or `// ...` style. For multi-line `/* ... */` comments, subsequent lines must start with `*` aligned with the `*` on the previous line.

```java
/*
 * This is          // And so           /* Or you can
 * okay.            // is this.          * even do this. */
 */
```

Comments are not enclosed in boxes drawn with asterisks or other characters.

>**Tip:** When writing multi-line comments, use the `/* ... */` style if you want automatic code formatters to re-wrap the lines when necessary (paragraph-style). Most formatters don't re-wrap lines in `// ...` style comment blocks.

#### <span id="4.8.7">4.8.7 Modifiers</span>

Class and member modifiers, when present, appear in the order recommended by the Java Language Specification:

```java
public protected private abstract default static final transient volatile synchronized native strictfp
```

#### <span id="4.8.8">4.8.8 Numeric Literals</span>

`long`-valued integer literals use an uppercase `L` suffix, never lowercase (to avoid confusion with the digit `1`). For example, `3000000000L` rather than `3000000000l`.

## <span id="5">5 Naming</span>

### <span id="5.1">5.1 Rules common to all identifiers</span>

Identifiers use only ASCII letters and digits, and, in a small number of cases noted below, underscores.

In Google Style, special prefixes or suffixes are **not** used. For example, these names are not Google Style: `name_`, `mName`, `s_name` and `kName`.

### <span id="5.2">5.2 Rules by identifier type</span>

#### <span id="5.2.1">5.2.1 Package names</span>

Package names are all lowercase, with consecutive words simply concatenated together (no underscores). For example, `com.example.deepspace`, not `com.example.deepSpace` or `com.example.deep_space` .

#### <span id="5.2.2">5.2.2 Class names</span>

Class names are written in **UpperCamelCase**.

Class names are typically nouns or noun phrases. For example, `Character` or `ImmutableList`.

Interface names may also be nouns or noun phrases, but may sometimes be adjectives or adjective phrases instead (for example, `Readable`).

There are no specific rules or even well-established conventions for naming annotation types.

Test classes are named starting with the name pf class they are testing, and ending with `Test`. For example, `HashTest` or `HashIntegrationTest`.

#### <span id="5.2.3">5.2.3 Method names</span>

Method names are written in **lowerCamelCase**.

Method names are typically verbs or verb phrases. For example, `sendMessage` or `stop ` .

Underscores may appear in JUnit test method names to separate logical components of the name, with each component written in lowerCamelCase. One typical pattern is `<methodUnderTest>_<state>`, for example `pop_emptyStack`.

#### <span id="5.2.4">5.2.4 Constant names</span>

Constant names use `CONSTANT_CASE`: all uppercase letters, with each word separated from the next by a single underscore. But what is a constant, exactly?

Constants are static final fields whose contents are deeply immutable and whose methods have no detectable side effects. This includes primitives, Strings, immutable types, and immutable collections of immutable types. If any of the instance's observable state can change, it is not a constant. Merely intending to never mutate the object is not enough. Examples:

```java
// Constants
static final int NUMBER = 5;
static final ImmutableList<String> NAMES = ImmutableList.of("Ed", "Ann");
static final ImmutableMap<String, Integer> AGES = ImmutableMap.of("Ed", 35, "Ann", 32);
static final Joiner COMMA_JOINER = Joiner.on(','); // because Joiner is immutable
static final SomeMutableType[] EMPTY_ARRAY = {};
enum SomeEnum { ENUM_CONSTANT }

// Not constants
static String nonFinal = "non-final";
final String nonStatic = "non-static";
static final Set<String> mutableCollection = new HashSet<String>();
static final ImmutableSet<SomeMutableType> mutableElements = ImmutableSet.of(mutable);
static final ImmutableMap<String, SomeMutableType> mutableValues =
    ImmutableMap.of("Ed", mutableInstance, "Ann", mutableInstance2);
static final Logger logger = Logger.getLogger(MyClass.getName());
static final String[] nonEmptyArray = {"these", "can", "change"};
```

These names are typically nouns or noun phrases.

#### <span id="5.2.5">5.2.5 Non-constant field names</span>

Non-constant field names are written in **lowerCamelCase**.

These names are typically nouns or noun phrases. For example, `computedValue` or `index`.

#### <span id="5.2.6">5.2.6 Parameter names</span>

Parameter names are written in **lowelCamelCase**.

One-character parameter names in public methods should be avoided.

#### <span id="5.2.7">5.2.7 Local variable names</span>

Local variable names are written in **lowelCamelCase**.

Even when final and immutable, local variables are not considered to be constants, and should not be styled as constants.

#### <span id="5.2.8">5.2.8 Type variable names</span>

Each type variable is named in one of two styles:

- A single capital letter, optionally followed by a single numeral (such as `E`, `T`, `X`, `T2`)
- A name in the form used for classes, followed by the capital letter `T` (such as `RequestT`, `FooBarT`).

### <span id="5.3">5.3 Camel case: defined</span>

Sometimes there is more than one reasonable way to convert an English phrase into camel case, such as when acronyms or unusual constructs like "IPv6" or "iOS" are present. To improve predictability, Google Style specifies the following (nearly) deterministic scheme.

Beginning with the prose form of the name:

1. Convert the phrase to plain ASCII and remove any apostrophes. For example, "MÃ¼ller's algorithm" might become "Muellers algorithm".
2. Divide this result into words, splitting on spaces and any remaining punctuation (typically hyphens).
   - *Recommended:* if any word already has a conventional camel-case appearance in common usage, split this into its constituent parts (e.g., "AdWords" becomes "ad words"). Note that a word such as "iOS" is not really in camel case *per se*; it defies *any* convention, so this recommendation does not apply.
3. Now lowercase *everything* (including acronyms), then uppercase only the first character of:
   - each word, to yield *upper camel case*, or
   - each word except the first, to yield *lower camel case*
4. Finally, join all the words into a single identifier.

Note that the casing of the original words is almost entirely disregarded. Examples:

| Prose form              | Correct                              | Incorrect           |
| :---------------------- | :----------------------------------- | :------------------ |
| "XML HTTP request"      | `XmlHttpRequest`                     | `XMLHTTPRequest`    |
| "new customer ID"       | `newCustomerId`                      | `newCustomerID`     |
| "inner stopwatch"       | `innerStopwatch`                     | `innerStopWatch`    |
| "supports IPv6 on iOS?" | `supportsIpv6OnIos`                  | `supportsIPv6OnIOS` |
| "YouTube importer"      | `YouTubeImporter` `YoutubeImporter`* |                     |

*Acceptable, but not recommended.

>**Note:** Some words are ambiguously hyphenated in the English language: for example "nonempty" and "non-empty" are both correct, so the method names `checkNonempty` and `checkNonEmpty` are likewise both correct.

## 6 <span id="6">Programming Practices</span>

### <span id="6.1">6.1 `@Override`: always used</span>

*Reasoning: A method is marked with the `@Override` annotation whenever it is legal. This includes a class method overriding a superclass method, a class method implementing an interface method, and an interface method respecifying a superinterface method.*

**Exception:** `@Override` may be omitted when the parent method is `@Deprecated`.

### 6.2 <span id="6.2">Caught exceptions: not ignored</span>

*Reasoning: Except as noted below, it is very rarely correct to do nothing in response to a caught exception. (Typical responses are to log it, or if it is considered "impossible", rethrow it as an `AssertionError`.)*

When it truly is appropriate to take no action whatsoever in a catch block, the reason this is justified is explained in a comment.

    try {
        int i = Integer.parseInt(response);
        return handleNumericResponse(i);
    } catch (NumberFormatException ok) {
        // it's not numeric; that's fine, just continue
    }
    return handleTextResponse(response);

**Exception:** In tests, a caught exception may be ignored without comment _if_ its name is or begins with `expected`. The following is a very common idiom for ensuring that the code under test _does_ throw an exception of the expected type, so a comment is unnecessary here.

    try {
        emptyStack.pop();
        fail();
    } catch (NoSuchElementException expected) {
    }

### <span id="6.3">6.3 Static members: qualified using class</span>

When a reference to a static class member must be qualified, it is qualified with that class's name, not with a reference or expression of that class's type.

    Foo aFoo = ...;
    Foo.aStaticMethod(); // good
    aFoo.aStaticMethod(); // bad
    somethingThatYieldsAFoo().aStaticMethod(); // very bad

### <span id="6.4">6.4 Constructs to Avoid</span>

#### 6.4.1 - Never use do..while

**Do not use `do..while` loops.**

*Reasoning: Consider that the programmer looking at your code is probably examining
each method starting at the top and working down. When encountering a loop, the first
thing the programmer wants to know is what terminates the loop. If you have that logic at
the bottom, it is harder to read. Further, many less experienced programmers are not
familiar with do..while, but may be required to modify your code.*

So rather than:

    boolean done = false;
    do{
    ...
    } while (!done)

use:

    boolean done = false;
    while (!done){
       ...
    }

<a name="return"></a>
#### 6.4.2 - Never use <code>return</code> in the middle of a method

**`return` is to be used at the end of a method only.**

*Reasoning: Using <code>return</code> in the middle of a method makes it difficult to
later break the method into smaller methods. It also forces the developer to consider more
than one exit point to a method. *

#### 6.4.3 - Never use <code>continue</code></h2>

**Never use `continue`.**

*Reasoning: Using `continue` makes it difficult to later break the
construct into smaller constructs or methods. It also forces the developer to consider
more than one end point for a construct. *

#### 6.4.4 - Never use `break` other than in a switch statement</h2>

**`break` is used only for switch statement control.**

*Reasoning: Using `break`, other than for switch statement control, makes
it difficult to later break a construct into smaller constructs or methods. It also forces
the developer to consider more than one end point for a construct. *

#### 6.4.5 Never use `Finalizers`

**It is *extremely rare* to override `Object.finalize`.**

*Reasoning: Don't do it. If you absolutely must, first read and understand [_Effective Java_ Item 7,](http://books.google.com/books?isbn=8131726592) "Avoid Finalizers," very carefully, and _then_ don't do it.*

### <span id="6.5">6.5 Do Not Compound Increment or Decrement Operators</span>

**Use a separate line for an increment or decrement.**

*Reasoning:  Compounding increment or decrement operators into
method calls or math is not clear to less experienced programmers who
may be required to modify your code.*

Examples:

    foo(x++); // NO!

    foo(x);   // YES!
    x++;


    y += 100 * x++;  // NO!

    y += 100 * x;    // YES!
    x++;

Note: i++ and ++i are equally fast, and i++ seems more consistent with the
rest of the language. Since the above prevents any use of a case where ++i
could make a difference, never use pre- increment/decrement.

### 6.6 <span id="6.6">Access</span>

**All fields must be private, except for some constants.**

## 7 <span id="7">Javadoc</span>

### <span id="7.1">7.1 Self-Documenting Code</span>

    "Any fool can write code that a computer can understand.
    Good programmers write code that humans can understand."

    --- Martin Fowler, Refactoring: Improving the Design of Existing Code

Rather than trying to document how you perform a complex algorithm, try to** make the
algorithm easier to read** by introducing more identifiers. This helps in the future in case the
algorithm changes but someone forgets to change the documentation.

Example:
  <ul>Instead of:

    if ( (hero == theTick) &amp;&amp; ( (sidekick == arthur) || (sidekick == speak) ) )

  </ul><ul>Use:

    boolean isTickSidekick = ( (sidekick == arthur) || (sidekick == speak) );
    if ( (hero == theTick) &amp;&amp; isTickSidekick )

  </ul>

### <span id="7.2">7.2 Formatting</span>

#### 7.2.1 General form

The _basic_ formatting of Javadoc blocks is as seen in this example:

    /**
     * Multiple lines of Javadoc text are written here,
     * wrapped normally...
     */
    public int method(String p1) { ... }

... or in this single-line example:

    /** An especially short bit of Javadoc. */

The basic form is always acceptable. The single-line form may be substituted when the entirety of the Javadoc block (including comment markers) can fit on a single line. Note that this only applies when there are no block tags such as `@return`.

#### 7.2.2 Paragraphs

One blank lineâ€”that is, a line containing only the aligned leading asterisk (`*`)â€”appears between paragraphs, and before the group of block tags if present. Each paragraph but the first has `<p>` immediately before the first word, with no space after.

#### 7.2.3 Block tags

Any of the standard "block tags" that are used appear in the order `@param`, `@return`, `@throws`, `@deprecated`, and these four types never appear with an empty description. When a block tag doesn't fit on a single line, continuation lines are indented four (or more) spaces from the position of the `@`.

### <span id="7.3">7.3 The summary fragment</span>

Each Javadoc block begins with a brief **summary fragment**. This fragment is very important: it is the only part of the text that appears in certain contexts such as class and method indexes.

This is a fragmentâ€”a noun phrase or verb phrase, not a complete sentence. It does **not** begin with `A {@code Foo} is a...`, or `This method returns...`, nor does it form a complete imperative sentence like `Save the record.`. However, the fragment is capitalized and punctuated as if it were a complete sentence.

**Tip:** A common mistake is to write simple Javadoc in the form `/** @return the customer ID */`. This is incorrect, and should be changed to `/** Returns the customer ID. */`.

### <span id="7.4">7.4 Where Javadoc is used</span>

At the _minimum_, Javadoc is present for every `public` class, and every `public` or `protected` member of such a class, with a few exceptions noted below.

Additional Javadoc content may also be present, as explained in Section 7.3.4, [Non-required Javadoc](#s7.3.4-javadoc-non-required).

#### 7.4.1 Exception: self-explanatory methods

Javadoc is optional for "simple, obvious" methods like `getFoo`, in cases where there _really and truly_ is nothing else worthwhile to say but "Returns the foo".

>**Important:** it is not appropriate to cite this exception to justify omitting relevant information that a typical reader might need to know. For example, for a method named `getCanonicalName`, don't omit its documentation (with the rationale that it would say only `/** Returns the canonical name. */`) if a typical reader may have no idea what the term "canonical name" means!

#### 7.4.2 Exception: overrides

Javadoc is not always present on a method that overrides a supertype method.

#### 7.4.3 Non-required Javadoc

Other classes and members have Javadoc _as needed or desired_.

Whenever an implementation comment would be used to define the overall purpose or behavior of a class or member, that comment is written as Javadoc instead (using `/**`).

Non-required Javadoc is not strictly required to follow the formatting rules of Sections 7.1.2, 7.1.3, and 7.2, though it is of course recommended.

## <span id="8">Reference</span>

- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
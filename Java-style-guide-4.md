## 4 Formatting

**Terminology Note:** *block-like construct* refers to the body of a class, method or constructor. Note that, by Section 4.8.3.1 on [array initializers](https://google.github.io/styleguide/javaguide.html#s4.8.3.1-array-initializers), any array initializer *may* optionally be treated as if it were a block-like construct.





### 4.1 Braces

#### 4.1.1 Braces are used where optionalatements, even when the body is empty or contains only a single statement.

#### 4.1.2 Nonempty blocks: K & R style

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

A few exceptions for enum classes are given in Section 4.8.1, [Enum classes](https://google.github.io/styleguide/javaguide.html#s4.8.1-enum-classes).





#### 4.1.3 Empty blocks: may be concise

An empty block or block-like construct may be in K & R style (as described in [Section 4.1.2](https://google.github.io/styleguide/javaguide.html#s4.1.2-blocks-k-r-style)). Alternatively, it may be closed immediately after it is opened, with no characters or line break in between (`{}`), **unless** it is part of a *multi-block statement* (one that directly contains multiple blocks: `if/else` or `try/catch/finally`).

Examples:

```java
  // This is acceptable
  void doNothing() {}

  // This is equally acceptable
  void doNothingElse() {
  }
  // This is not acceptable: No concise empty blocks in a multi-block statement
  try {
    doSomething();
  } catch (Exception e) {}
```

### 4.2 Block indentation: +2 spaces

Each time a new block or block-like construct is opened, the indent increases by two spaces. When the block ends, the indent returns to the previous indent level. The indent level applies to both code and comments throughout the block. (See the example in Section 4.1.2, [Nonempty blocks: K & R Style](https://google.github.io/styleguide/javaguide.html#s4.1.2-blocks-k-r-style).)

### 4.3 One statement per line

Each statement is followed by a line break.





### 4.4 Column limit: 100

Java code has a column limit of 100 characters. A "character" means any Unicode code point. Except as noted below, any line that would exceed this limit must be line-wrapped, as explained in Section 4.5, [Line-wrapping](https://google.github.io/styleguide/javaguide.html#s4.5-line-wrapping).

Each Unicode code point counts as one character, even if its display width is greater or less. For example, if using [fullwidth characters](https://en.wikipedia.org/wiki/Halfwidth_and_fullwidth_forms), you may choose to wrap the line earlier than where this rule strictly requires.

**Exceptions:**

1. Lines where obeying the column limit is not possible (for example, a long URL in Javadoc, or a long JSNI method reference).
2. `package` and `import` statements (see Sections 3.2 [Package statement](https://google.github.io/styleguide/javaguide.html#s3.2-package-statement) and 3.3 [Import statements](https://google.github.io/styleguide/javaguide.html#s3.3-import-statements)).
3. Command lines in a comment that may be cut-and-pasted into a shell.

### 4.5 Line-wrapping

**Terminology Note:** When code that might otherwise legally occupy a single line is divided into multiple lines, this activity is called *line-wrapping*.

There is no comprehensive, deterministic formula showing *exactly* how to line-wrap in every situation. Very often there are several valid ways to line-wrap the same piece of code.

**Note:** While the typical reason for line-wrapping is to avoid overflowing the column limit, even code that would in fact fit within the column limit *may* be line-wrapped at the author's discretion.

**Tip:** Extracting a method or local variable may solve the problem without the need to line-wrap.

#### 4.5.1 Where to break

The prime directive of line-wrapping is: prefer to break at a **higher syntactic level**. Also:

1. When a line is broken at a

    

   non-assignment

    

   operator the break comes

    

   before

    

   the symbol. (Note that this is not the same practice used in Google style for other languages, such as C++ and JavaScript.)

   - This also applies to the following "operator-like" symbols:
     - the dot separator (`.`)
     - the two colons of a method reference (`::`)
     - an ampersand in a type bound (`<T extends Foo & Bar>`)
     - a pipe in a catch block (`catch (FooException | BarException e)`).

2. When a line is broken at an

    

   assignment

    

   operator the break typically comes

    

   after

    

   the symbol, but either way is acceptable.

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

**Note:** The primary goal for line wrapping is to have clear code, *not necessarily* code that fits in the smallest number of lines.





#### 4.5.2 Indent continuation lines at least +4 spaces

When line-wrapping, each line after the first (each *continuation line*) is indented at least +4 from the original line.

When there are multiple continuation lines, indentation may be varied beyond +4 as desired. In general, two continuation lines use the same indentation level if and only if they begin with syntactically parallel elements.

Section 4.6.3 on [Horizontal alignment](https://google.github.io/styleguide/javaguide.html#s4.6.3-horizontal-alignment) addresses the discouraged practice of using a variable number of spaces to align certain tokens with previous lines.

### 4.6 Whitespace

#### 4.6.1 Vertical Whitespace

A single blank line always appears:

1. Between

    

   consecutive members or initializers of a class: fields, constructors, methods, nested classes, static initializers, and instance initializers.

   - **Exception:** A blank line between two consecutive fields (having no other code between them) is optional. Such blank lines are used as needed to create *logical groupings* of fields.
   - **Exception:** Blank lines between enum constants are covered in [Section 4.8.1](https://google.github.io/styleguide/javaguide.html#s4.8.1-enum-classes).

2. As required by other sections of this document (such as Section 3, [Source file structure](https://google.github.io/styleguide/javaguide.html#s3-source-file-structure), and Section 3.3, [Import statements](https://google.github.io/styleguide/javaguide.html#s3.3-import-statements)).

A single blank line may also appear anywhere it improves readability, for example between statements to organize the code into logical subsections. A blank line before the first member or initializer, or after the last member or initializer of the class, is neither encouraged nor discouraged.

*Multiple* consecutive blank lines are permitted, but never required (or encouraged).

#### 4.6.2 Horizontal whitespace

Beyond where required by the language or other style rules, and apart from literals, comments and Javadoc, a single ASCII space also appears in the following places **only**.

1. Separating any reserved word, such as `if`, `for` or `catch`, from an open parenthesis (`(`) that follows it on that line

2. Separating any reserved word, such as `else` or `catch`, from a closing curly brace (`}`) that precedes it on that line

3. Before any open curly brace (

   ```java
   {
   ```

   ), with two exceptions:

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

#### 4.6.3 Horizontal alignment: never required

**Terminology Note:** *Horizontal alignment* is the practice of adding a variable number of additional spaces in your code with the goal of making certain tokens appear directly below certain other tokens on previous lines.

This practice is permitted, but is **never required** by Google Style. It is not even required to *maintain* horizontal alignment in places where it was already used.

Here is an example without alignment, then using alignment:

```java
private int x; // this is fine
private Color color; // this too

private int   x;      // permitted, but future edits
private Color color;  // may leave it unaligned
```

**Tip:** Alignment can aid readability, but it creates problems for future maintenance. Consider a future change that needs to touch just one line. This change may leave the formerly-pleasing formatting mangled, and that is **allowed**. More often it prompts the coder (perhaps you) to adjust whitespace on nearby lines as well, possibly triggering a cascading series of reformattings. That one-line change now has a "blast radius." This can at worst result in pointless busywork, but at best it still corrupts version history information, slows down reviewers and exacerbates merge conflicts.





### 4.7 Grouping parentheses: recommended

Optional grouping parentheses are omitted only when author and reviewer agree that there is no reasonable chance the code will be misinterpreted without them, nor would they have made the code easier to read. It is *not* reasonable to assume that every reader has the entire Java operator precedence table memorized.

### 4.8 Specific constructs

#### 4.8.1 Enum classes

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





#### 4.8.2 Variable declarations

##### 4.8.2.1 One variable per declaration

Every variable declaration (field or local) declares only one variable: declarations such as `int a, b;` are not used.

**Exception:** Multiple variable declarations are acceptable in the header of a `for` loop.

##### 4.8.2.2 Declared when needed

Local variables are **not** habitually declared at the start of their containing block or block-like construct. Instead, local variables are declared close to the point they are first used (within reason), to minimize their scope. Local variable declarations typically have initializers, or are initialized immediately after declaration.

#### 4.8.3 Arrays

##### 4.8.3.1 Array initializers: can be "block-like"

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

##### 4.8.3.2 No C-style array declarations

The square brackets form a part of the *type*, not the variable: `String[] args`, not `String args[]`.

#### 4.8.4 Switch statements

**Terminology Note:** Inside the braces of a *switch block* are one or more *statement groups*. Each statement group consists of one or more *switch labels* (either `case FOO:` or `default:`), followed by one or more statements (or, for the *last* statement group, *zero* or more statements).

##### 4.8.4.1 Indentation

As with any other block, the contents of a switch block are indented +2.

After a switch label, there is a line break, and the indentation level is increased +2, exactly as if a block were being opened. The following switch label returns to the previous indentation level, as if a block had been closed.





##### 4.8.4.2 Fall-through: commented

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

##### 4.8.4.3 The `default` case is present

Each switch statement includes a `default` statement group, even if it contains no code.

**Exception:** A switch statement for an `enum` type *may* omit the `default` statement group, *if* it includes explicit cases covering *all* possible values of that type. This enables IDEs or other static analysis tools to issue a warning if any cases were missed.





#### 4.8.5 Annotations

Annotations applying to a class, method or constructor appear immediately after the documentation block, and each annotation is listed on a line of its own (that is, one annotation per line). These line breaks do not constitute line-wrapping (Section 4.5, [Line-wrapping](https://google.github.io/styleguide/javaguide.html#s4.5-line-wrapping)), so the indentation level is not increased. Example:

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





#### 4.8.6 Comments

This section addresses *implementation comments*. Javadoc is addressed separately in Section 7, [Javadoc](https://google.github.io/styleguide/javaguide.html#s7-javadoc).

Any line break may be preceded by arbitrary whitespace followed by an implementation comment. Such a comment renders the line non-blank.

##### 4.8.6.1 Block comment style

Block comments are indented at the same level as the surrounding code. They may be in `/* ... */` style or `// ...` style. For multi-line `/* ... */` comments, subsequent lines must start with `*` aligned with the `*` on the previous line.

```java
/*
 * This is          // And so           /* Or you can
 * okay.            // is this.          * even do this. */
 */
```

Comments are not enclosed in boxes drawn with asterisks or other characters.

**Tip:** When writing multi-line comments, use the `/* ... */` style if you want automatic code formatters to re-wrap the lines when necessary (paragraph-style). Most formatters don't re-wrap lines in `// ...` style comment blocks.





#### 4.8.7 Modifiers

Class and member modifiers, when present, appear in the order recommended by the Java Language Specification:

```
public protected private abstract default static final transient volatile synchronized native strictfp
```

#### 4.8.8 Numeric Literals

```
long`-valued integer literals use an uppercase `L` suffix, never lowercase (to avoid confusion with the digit `1`). For example, `3000000000L` rather than `3000000000l
```
6 <span id="6">Programming Practices</span>
-----------------------

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

7 <span id="7">Javadoc</span>
---------
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

/\*\*
 \* Multiple lines of Javadoc text are written here,
 \* wrapped normally...
 */
public int method(String p1) { ... }

... or in this single-line example:

/\*\* An especially short bit of Javadoc. */

The basic form is always acceptable. The single-line form may be substituted when the entirety of the Javadoc block (including comment markers) can fit on a single line. Note that this only applies when there are no block tags such as `@return`.

#### 7.2.2 Paragraphs

One blank line—that is, a line containing only the aligned leading asterisk (`*`)—appears between paragraphs, and before the group of block tags if present. Each paragraph but the first has `<p>` immediately before the first word, with no space after.

#### 7.2.3 Block tags

Any of the standard "block tags" that are used appear in the order `@param`, `@return`, `@throws`, `@deprecated`, and these four types never appear with an empty description. When a block tag doesn't fit on a single line, continuation lines are indented four (or more) spaces from the position of the `@`.

### <span id="7.3">7.3 The summary fragment</span>

Each Javadoc block begins with a brief **summary fragment**. This fragment is very important: it is the only part of the text that appears in certain contexts such as class and method indexes.

This is a fragment—a noun phrase or verb phrase, not a complete sentence. It does **not** begin with `A {@code Foo} is a...`, or `This method returns...`, nor does it form a complete imperative sentence like `Save the record.`. However, the fragment is capitalized and punctuated as if it were a complete sentence.

**Tip:** A common mistake is to write simple Javadoc in the form `/** @return the customer ID */`. This is incorrect, and should be changed to `/** Returns the customer ID. */`.

### <span id="7.4">7.4 Where Javadoc is used</span>

At the _minimum_, Javadoc is present for every `public` class, and every `public` or `protected` member of such a class, with a few exceptions noted below.

Additional Javadoc content may also be present, as explained in Section 7.3.4, [Non-required Javadoc](#s7.3.4-javadoc-non-required).

#### 7.4.1 Exception: self-explanatory methods

Javadoc is optional for "simple, obvious" methods like `getFoo`, in cases where there _really and truly_ is nothing else worthwhile to say but "Returns the foo".

**Important:** it is not appropriate to cite this exception to justify omitting relevant information that a typical reader might need to know. For example, for a method named `getCanonicalName`, don't omit its documentation (with the rationale that it would say only `/** Returns the canonical name. */`) if a typical reader may have no idea what the term "canonical name" means!

#### 7.4.2 Exception: overrides

Javadoc is not always present on a method that overrides a supertype method.

#### 7.4.3 Non-required Javadoc

Other classes and members have Javadoc _as needed or desired_.

Whenever an implementation comment would be used to define the overall purpose or behavior of a class or member, that comment is written as Javadoc instead (using `/**`).

Non-required Javadoc is not strictly required to follow the formatting rules of Sections 7.1.2, 7.1.3, and 7.2, though it is of course recommended.

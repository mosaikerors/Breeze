## 3 Source file structure

A source file consists of, **in order**:

1. License or copyright information, if present
2. Package statement
3. Import statements
4. Exactly one top-level class

**Exactly one blank line** separates each section that is present.

### 3.1 License or copyright information, if present

If license or copyright information belongs in a file, it belongs here.

### 3.2 Package statement

The package statement is **not line-wrapped**.

### 3.3 Import statements

#### 3.3.1 No wildcard imports

Wildcard imports are not used.

#### 3.3.2 No line-wrapping

Import statements are **not line-wrapped**.

#### 3.3.3 Ordering and spacing

Imports are ordered as follows:

1. All static imports in a single block.
2. All non-static imports in a single block.

If there are both static and non-static imports, a single blank line separates the two blocks. There are no other blank lines between import statements.

Within each block the imported **names** appear in ASCII sort order.

#### 3.3.4 No static import for classes

Static import is not used for static nested classes. They are imported with normal imports. 

### 3.4 Class declaration

#### 3.4.1 Exactly one top-level class declaration

Each top-level class resides in a source file of its own.

#### 3.4.2 Ordering of class contents

The order you choose for the members and initializers of your class should be **logical**, which means its maintainer could give an explanation if asked. (chronological order is not recommended)

Also, when a class has multiple constructors, or multiple methods with the same name, these appear sequentially, with no other code in between.

## 5 Naming

### 5.1 Rules common to all identifiers

Identifiers use only ASCII letters and digits, and, in a small number of cases noted below, underscores.

In Google Style, special prefixes or suffixes are **not** used. For example, these names are not Google Style: `name_`, `mName`, `s_name` and `kName `.

### 5.2 Rules by identifier type

#### 5.2.1 Package names

Package names are all lowercase, with consecutive words simply concatenated together (no underscores). For example, `com.example.deepspace`, not `com.example.deepSpace` or `com.example.deep_space` .

#### 5.2.2 Class names

Class names are written in **UpperCamelCase**.

Class names are typically nouns or noun phrases. For example, `Character` or `ImmutableList`. 

Interface names may also be nouns or noun phrases, but may sometimes be adjectives or adjective phrases instead (for example, `Readable`).

There are no specific rules or even well-established conventions for naming annotation types.

Test classes are named starting with the name pf class they are testing, and ending with `Test`. For example, `HashTest` or `HashIntegrationTest`.

#### 5.2.3 Method names

Method names are written in **lowerCamelCase**.

Method names are typically verbs or verb phrases. For example, `sendMessage` or `stop ` .

Underscores may appear in JUnit test method names to separate logical components of the name, with each component written in lowerCamelCase. One typical pattern is `<methodUnderTest>_<state>`, for example `pop_emptyStack`.

#### 5.2.4 Constant names

Constant names use `CONSTANT_CASE`: all uppercase letters, with each word separated from the next by a single underscore.

These names are typically nouns or noun phrases.

#### 5.2.5 Non-constant field names

Non-constant field names are written in **lowerCamelCase**.

These names are typically nouns or noun phrases. For example, `computedValue` or `index`.

#### 5.2.6 Parameter names

Parameter names are written in **lowelCamelCase**.

One-character parameter names in public methods should be avoided.

#### 5.2.7 Local variable names

Local variable names are written in **lowelCamelCase**.

Even when final and immutable, local variables are not considered to be constants, and should not be styled as constants.

#### 5.2.8 Type variable names

Each type variable is named in one of two styles:

+ A single capital letter, optionally followed by a single numeral (such as `E`, `T`, `X`, `T2`)
+ A name in the form used for classes, followed by the capital letter `T` (such as `RequestT`, `FooBarT`).

### 5.3 Camel case: defined

Sometimes there is more than one reasonable way to convert an English phrase into camel case, such as when acronyms or unusual constructs like "IPv6" or "iOS" are present. To improve predictability, Google Style specifies the following (nearly) deterministic scheme.

Beginning with the prose form of the name:

1. Convert the phrase to plain ASCII and remove any apostrophes. For example, "Müller's algorithm" might become "Muellers algorithm".
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

**Note:** Some words are ambiguously hyphenated in the English language: for example "nonempty" and "non-empty" are both correct, so the method names `checkNonempty` and `checkNonEmpty` are likewise both correct.
The provided Drawing System code has several issues that could be improved through refactoring. Here are two primary issues and the suggested refactorings:

### Issue 1: Format-Specific Logic in Shape Classes

The `Shape` interface and its implementations (`Line`, `Rectangle`, `Triangle`) are burdened with the responsibility of converting shapes to specific image formats (JPEG, PNG), as seen in the `toJPEG` and `toPNG` methods within the `Line` class and the conditional logic within the `draw` method of the `Shape` interface. This design violates the Single Responsibility Principle (SRP) by mixing shape representation logic with image format conversion logic.

#### Refactoring Suggestion:

- **Separate Concerns:** Introduce a new layer of abstraction dedicated to format conversion. This could be a set of classes or interfaces representing different format converters (e.g., `ImageFormatConverter` with implementations like `JPEGConverter` and `PNGConverter`). These converters would take the responsibility of converting shapes to the desired format.

- **Visitor Pattern:** Implement the Visitor pattern to allow adding new operations (like converting to different formats) without changing the shape classes. This pattern would enable shape classes to accept a visitor (in this case, a format converter) that performs operations based on the shape's type.

### Issue 2: Tight Coupling Between Drawing Logic and Specific Writer Implementations

The `Drawing` class directly instantiates `JPEGWriter` or `PNGWriter` based on the format string, tightly coupling the drawing logic to specific writer implementations. This design limits flexibility and extensibility, making it hard to support new formats without modifying the `Drawing` class.

#### Refactoring Suggestion:

- **Factory Pattern:** Utilize a Factory pattern to abstract the creation of `Writer` instances. The factory would return an appropriate writer based on the format, reducing the coupling between the `Drawing` class and specific writer classes.

- **Strategy Pattern:** Implement a Strategy pattern for selecting the appropriate writing strategy at runtime. This could involve creating a `WriterStrategy` interface with different implementations for each format. The `Drawing` class would then use a strategy to write shapes to a file, decoupling it from specific writer classes.

By addressing these issues through the suggested refactorings, the Drawing System would become more modular, easier to maintain, and more open to extension. Separating format conversion from shape logic and abstracting away the specifics of file writing would enable easier addition of new shapes and formats, adhering to both the Open/Closed Principle and the Single Responsibility Principle.
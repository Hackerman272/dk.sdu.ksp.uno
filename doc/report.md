# Assignment 2 in Object-oriented Programming

## 1. Status of the Implementation

I have successfully implemented all subtasks of the UNO game assignment, including the core game mechanics and the extension with action cards.

### 1.1 Example output

Here's a snippet of the game output:

```
Current player: Computer1
Top card: RED_9
Draw pile size: 54
Computer1's hand: 
0:GREEN_6 | 1:GREEN_2 | 2:YELLOW_7 | 3:BLUE_7 | 4:BLUE_0 | 5:BLUE_7 | 6:BLUE_3 | 
Computer1 played: BLUE_7

Current player: Computer2
Top card: BLUE_7
Draw pile size: 54
Computer2's hand: 
0:GREEN_9 | 1:RED_4 | 2:GREEN_5 | 3:GREEN_3 | 4:GREEN_0 | 5:YELLOW_4 | 6:YELLOW_8 | 
Computer2 has no playable hand. Drawing.
Computer2 has no playable hand. Passing turn.

Current player: Computer3
Top card: BLUE_7
Draw pile size: 53
Computer3's hand: 
0:RED_9 | 1:BLUE_4 | 2:BLUE_1 | 3:GREEN_6 | 4:GREEN_5 | 5:YELLOW_1 | 
Computer3 played: BLUE_4
```

## 2. Known Bugs

There are no known bugs in the current implementation, or I haven`t face with some of them yet.

## 3. Design changes

No significant changes were made to the initial design.

## 4. Application of OOP Principles

### 4.1 Encapsulation

Encapsulation is well-implemented throughout the project. For example, in the `Player` class:

```java
public abstract class Player implements Describable {
    private String name;
    private ArrayList<Card> hand;

    // Public methods to interact with private data
    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    // Other methods...
}
```

This approach ensures that the internal state of objects is protected and can only be accessed or modified through well-defined special methods.

### 4.2 Inheritance

Inheritance is extensively used in the card hierarchy:

```java
public abstract class Card { ... }
public class NumberCard extends Card { ... }
public abstract class ActionCard extends Card { ... }
public class WildCard extends ActionCard { ... }
public class WildDraw4Card extends ActionCard { ... }
```

This structure allows for code reuse and establishes a clear "root-child" relationship between different types of cards.

### 4.3 Polymorphism

Polymorphism is demonstrated in several areas, particularly in handling different types of cards:

```java
if (playedCard instanceof ActionCard) {
    ((ActionCard) playedCard).action(this);
}
```

This allows different action cards to have their own implementation of the `action` method, which is called polymorphically.

### 4.4 Abstraction

Abstraction is used to hide complex implementation details. For example, the `DrawPile` and `DiscardPile` classes abstract away the details of card management.

Users of these classes don't need to know how cards are stored or managed internally.

## 5. Improvements and Future Work

Potential improvements and future work could include:

1. Implementing a pretty UI for a more convenient experience.
2. Fully implement UNO rules.
3. Adding online multiplayer.
4. Implementing an imitation of AI for bots (computer), with different hard level.
5. Adding a players history and statistics, using integration with some database, for example PostgreSQL.
6. Implementing autotests.
7. Implementing multiple sequences of session with aim to detect the best tactics, using data analysis and visualisation tools.

## 6. Conclusion

This assignment has been an excellent opportunity to apply and reinforce object-oriented programming principles. The UNO game implementation demonstrates the power of OOP in creating modular, extensible, and maintainable code.

The use of abstractions, inheritance, and polymorphism allowed for a flexible design that could easily accommodate new card types and game rules. Encapsulation helped in managing the complexity of the game state and ensuring that objects maintain a consistent internal state.

In future software development projects, I will definitely leverage these OOP principles to create robust and scalable solutions. This assignment has reinforced the importance of careful design and the benefits of following OOP best practices.
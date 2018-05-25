# 2018 SYSU Practical Training Summary

>Overwhelmed in practical training for three weeks, all of us, coders of SE, participated in  a coding journey. Although exhausted, we all enjoyed this fantastic experience. The weekends seem like nothing but sleeping, eating and coding. Whereas it's the crazy jobs and devoted sprits that make this period so valuable. During these weeks, I gained so much interesting knowledge and experience. *And even the bugs encountered has been my friends!!!*  Nevertheless, I cherish these moments so much that I greatly enjoy this training.

## Stage 1

>Actually, I was busy with an exam in that week, so I didn't literally take part in that stage. And I finish the Stage 1 in my second week of training. I quickly learn the **Vim Editor, Ant, JUnit, Sonar** under the help of my generous friends, and quickly complete the coding exercise of the next stage.

### Vim Editor

**Vim** acts as one of the most important editors in Linux. For this reason, I have acquainted **Vim Editor** and **Gedit** in my first year in college when using Linux to finish my 2017 practical training. So this make it an easy job for me to review it.

### Ant

Not like **Vim**, **Ant** is a stranger to me. Actually, I became totally puzzled by the configuration building. Thanks to my friends, I can overcome this difficulty so quickly and their help really save me a lot of time. So why it called **Ant**, I think this kit works like ants, aggregating small parts to build a huge project.

### JUnit

Oh... **JUnit** is completely a big problem, I built the configuration for a whole day by trials and errors!!! *(Never trust the resources on web ￣へ￣! )* 

### Sonar

Modifying the properties and learning a little of the **Sonar** formatted files, I can evaluate my codes on the local host. To be honest, I was surprised by its strong function, and totally amazed by the detailed checks. However, the major degrading is really a headache!!!

### Tiny Java Project

We used java to code in this practical training and were required to finish a small project named **Calculator**. In this project, we implemented a basic calculator as designed owning the abilities of addition, subtraction, multiplication and devision. I enrolled an elective Java class in my major and know Java a bit, so except for the UI API, it didn't spare me much time to finish this project. 

### Bug Runner

At last, I run the bug runner and glanced at the implementation of the lovely bugs. However, *I didn't imagined that this small bugs, who is so cute and harmless, developed to the terrible dream of future work, which is beyond my wildest dream (＠_＠).*

## Stage 2

> Exercise in Stage 2 is the beginning of the really coding task in my perspective. In this stage, we were going to roll up our sleeves depicting all kinds of bugs and actors.

### Crazy Bugs

Have you ever seen the bugs flying by the water in summer? If your answer is yes, you must get that how annoying are those bugs. Excluding BoxBug, we were desperate playing with the **CircleBug, DancingBug, SpiralBug and ZBug**. **CircleBug** shall turn twice rather than once; the **SprialBug** leaves its departure and goes far spirally; the **DancingBug** is drunk and randomly choose a direction, and she is longing for a singleton to bring her home ( ‵▽′)ψ; and **ZBug** is foolish that only is able to move in zigzag. Although seemed onerous, these buggies are really kind when compared to the actors in the actors listed after. The construction of them is not so difficult and they are all friendly to debug. Anyway, there is a old saying, *"Every programmer hates bugs."  ╮（﹀_﹀）╭*

### Jumper

Fighting with bugs for a long time, I thought the next part may be some relatively light work. However, the reality is relentless. I start to believe the fact that, not only the bugs, some actors are also bothering. In this part, we were expected to generate a **Jumper**. Jumping was he, tired I was. After jumping over so many stones, my **Jumper** finally took effect and he seemed vigorous enough to pass the test!!! ^O^

### Critters

I used to hate bugs, but it's until I created these merciless critters that I found that they are actually bitter. Before moving, critters process other actors in some way. They can examine them, move them, or even eat them. Critters eat actors that are not rocks or critters. This behavior is either inherited or overridden in subclasses. 

A **RockHound** is so hungry that he even eats rocks in that list from the grid. A **BlusterCritter** looks at all of the neighbors within two steps of its current location. It counts the number of critters in those locations. If there are fewer than c critters, the **BlusterCritter’s** color gets brighter. If there are c or more critters, the **BlusterCritter’s** color darkens as it's timid.

A **ChameleonCritter** doesn’t so fierce that eating actors. Instead, it is hypocritical, when a **ChameleonCritter** processes actors, it randomly selects one and changes its own color to the color of the selected actor. A **ChameleonKid** inherit the bad habits of its parents, but it can only changes its color to the color of one of the actors immediately in front or behind.

A **CrabCritter** is a critter that eats whatever is found in the locations immediately in front, to the right-front, or to the left-front of it. A **CrabCritter** can move only to the right or to the left as a result of its bullying. When there is no room for its parallel crossing, it would turn around. Quicker one like the  **QuickCrab** move two spaces each step. A **KingCrab** causes each actor that it processes to move one location further away from itself. If the actor cannot move away, it would be removed from the grid.

There is always someone punish the bad guys. That is, *what goes around goes around. (ง •_•)ง*

### Grid

To make the bugs, critters and actors act in a specious environment, we make the **BoundedGrid** which has a DIY scale and **UnboundedGrid** without boundary. In this way, they have a larger place to play!!!

##Stage 3

>Stage 3 is consist of three project, firstly classical Lena was processed again using Java API. Secondly, I used some enhanced DFS methods to teach the maze bug and it seemed more clever. BFS and A star algorithm are used to solve the N-puzzle problem.

### Lena

Reading Lena using **BitMap**, we started to process the image.

Bitmap structure has these properties:
*Bitmap header: saves the overall information for bitmap files.
*Bitmap information: saves the details of bitmap images.
*Palette: save the definition of the color used.
*Bitmap data: saves the actual image of one pixel after another.

After the processing, we finally made her green (⊙ω⊙)... (ahah... of course also blue, red, and gray). 

I participating in a research of Computer Vision and I recommend CPP OpenCV library which providing further procession. 

### MazeBug

**MazeBug** is a new bug who are trying to find the final (a red rock) of the maze. It use Deep First Search to explore the maze. When the bug find a available direction, it would move until reach the dead end. The directions optimization is remarked as slope - the trend to move toward that particular direction. And the slope is modified by the destination inspector and with the move of the **MazeBug**.

In this part, I adjust parameters such as bonusSlope and stepLength to meet the least-step satisfaction of the **MazeBug** solution. After the comparison, the most appropriate bonusSlope is 4 or 5, and the stepLength is 100 (to inspect the destination every 100 steps). Moreover, my exploration covers the reset and lean methods. And the lean method generate a better performance over reset, eliminating about 50 steps in average in the dataset given and owning a smaller standard deviation.

### N-Puzzle

**N-Puzzle** facilitate Bread First Search. BFS are always "wide" as much as possible to search every node adjacency point, to find the shortest path from the source node to the destination node, thus the experiment using it to find eight digital problem of the optimal solution. As expected, the problem can be solved but not briefly enough. Based on this problem, the A star algorithm is put forward.

A star algorithm evaluate the cost of each movement and choose the cheapest cost as first choice. The cost is calculated by some attributes like geometric distance, Manhattan distance, the incorrect position, the wrong number behind... Thereafter, the relative optimal determination is made. 

Refer from the Kalman Filtering, I come up with a new hybrid prediction based on the neighborhood. To hybrid the measurement and prediction, we first need to get a predict value. Prediction is figure out by the neighbors who have already has a estimation. Average prediction of the target node equals the sum of depth multiply estimation. Hybrid is made using weight - estimateRate and predictRate. The deep depth node deserve a higher proportion, so the depth is taken into consideration and the primate node is hybridized more times. Considering the neighbors, the step is saved by about 30 steps in the given data.

## Conclusion

>That what I learnt in this practical training. *Little steps make a thousand miles.* Try hard like the **MazeBug** to explore the **UnboundedWorld**.

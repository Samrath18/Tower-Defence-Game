# 2024/05/05

# Tower Defense Game

A feature-rich tower defense game where strategy, resource management, and quick thinking collide. Players must defend their castle from waves of enemies by deploying troops, participating in mini-games, and mastering the art of resource allocation.

---

## Table of Contents

1. [Introduction](#introduction)
2. [Core Features](#core-features)
   - [Dynamic Gameplay](#dynamic-gameplay)
   - [Troop Deployment](#troop-deployment)
   - [Mini-Games](#mini-games)
   - [Enemy AI](#enemy-ai)
   - [Resource Management](#resource-management)
   - [Interactive Screens](#interactive-screens)
3. [Installation](#installation)
4. [How to Play](#how-to-play)
5. [File Descriptions](#file-descriptions)
6. [Future Enhancements](#future-enhancements)

---

## Introduction

In Tower Defense Game, you are the commander tasked with defending a castle from relentless waves of enemy troops. The game combines strategy, real-time action, and fun mini-games to keep players engaged. Deploy troops wisely, manage gold resources, and use buffs to survive increasingly difficult enemy attacks.

---

## Core Features

### Dynamic Gameplay

Tower Defense Game offers a dynamic experience, combining strategic planning and quick reflexes. Players must:
- Defend their castle using various troop types.
- Adapt to random mini-games that offer rewards or punishments.
- Tackle progressively harder waves of enemies.

### Troop Deployment

Troops are the backbone of your defense. Each troop type has distinct characteristics, requiring careful planning:
1. **Raider (Cost: 10 coins)**  
   - **Speed**: 10 (Fastest)
   - **Health**: 1 HP  
   - **Attack**: Melee, 1 damage  
   - **Strengths**: Swarm tactics.

2. **Puncher (Cost: 18 coins)**  
   - **Speed**: 7  
   - **Health**: 2 HP  
   - **Attack**: Melee, 1 damage  
   - **Strengths**: Moderate durability.

3. **Soldier (Cost: 25 coins)**  
   - **Speed**: 5  
   - **Health**: 4 HP  
   - **Attack**: Melee, 2 damage  
   - **Strengths**: Balanced stats.

4. **Archer (Cost: 25 coins)**  
   - **Speed**: 5  
   - **Health**: 3 HP  
   - **Attack**: Ranged, 2 damage  
   - **Strengths**: Ranged versatility.

5. **Shotgunner (Cost: 35 coins)**  
   - **Speed**: 3  
   - **Health**: 5 HP  
   - **Attack**: Ranged, 5 damage  
   - **Strengths**: Medium-range devastation.

6. **Sniper (Cost: 45 coins)**  
   - **Speed**: 2  
   - **Health**: 5 HP  
   - **Attack**: Ranged, 6 damage  
   - **Strengths**: Long-range precision.

7. **Super Warrior (Cost: 60 coins)**  
   - **Speed**: 1 (Slowest)  
   - **Health**: 12 HP  
   - **Attack**: Melee, 8 damage  
   - **Strengths**: Exceptional durability and damage.

### Mini-Games

Randomly triggered mini-games add variety to gameplay, impacting resources and buffs:

1. **Quick Math**:  
   Solve a sequence of math problems under a time limit to win buffs, such as increased gold generation or castle health recovery.

2. **Random Targets**:  
   Click on targets that appear randomly on the screen to score points. Win by reaching the score threshold before time runs out.

3. **Spam Click**:  
   Click a button repeatedly to fill the progress bar within the given time. Victory grants buffs, while failure results in penalties.

Each mini-game challenges different skills, ensuring dynamic and engaging gameplay.

### Enemy AI

The enemies in Tower Defense Game are as varied as your troops:
- **Goblin (Small)**: High speed, low health, melee attacker. Effective against unguarded castles.  
- **Wizard (Medium)**: Medium speed, ranged attacker. Strong against clustered troops.  
- **Giant (Large)**: Slow, tanky melee attacker. Best countered by high-damage units.

The game's AI increases difficulty over time by spawning tougher combinations of enemies, requiring players to adapt their strategies.

### Resource Management

Gold is the primary resource in Tower Defense Game:
- **Gold Generation**: Players earn gold automatically over time.
- **Gold Costs**: Deploying troops depletes gold, forcing players to balance between saving and spending.
- **Buffs/Debuffs**: Mini-games directly impact gold generation rates, providing a strategic layer.

Gold Coins are managed by the `GoldCoins.java` class, which ensures smooth timing and updates to the player's gold reserves.

### Interactive Screens

The game features multiple screens, each with its purpose:
- **Main Menu** (`MainMenu.java`): Start the game, access help, or quit.
- **Pause Screen** (`pauseScreen.java`): Pause, resume, or quit mid-game.
- **Win Screen** (`winScreen.java`): Celebrate your victory and view your score.
- **Lose Screen** (`LoseScreen.java`): Replay or return to the main menu upon defeat.
- **Help Screen**: Learn about troop types, enemy weaknesses, and gameplay tips.

---

### Infinite Mini-Games Mode

The **Infinite Mini-Games** mode offers a unique gameplay twist, allowing players to engage in endless rounds of mini-games. Unlike the main tower defense game, this mode focuses solely on mini-game challenges, testing the player's skills and endurance.

#### How It Works

1. **Access Infinite Mini-Games Mode**:
   - From the **Main Menu**, select the "Minigames" option to start the Infinite Mini-Games mode.

2. **Gameplay**:
   - Players are presented with random mini-games, selected from the available pool:
     - **Quick Math**: Solve a sequence of arithmetic problems under a strict time limit.
     - **Random Targets**: Click on appearing targets to achieve the required score before time runs out.
     - **Spam Click**: Click as fast as possible to fill a progress bar within the allotted time.
   - Mini-games appear one after the other, with no breaks, increasing the challenge.

3. **Streak System**:
   - Players aim to maintain a streak by winning consecutive mini-games.
   - Losing a mini-game breaks the streak, and in some cases, the Infinite Mini-Games session ends.
   - A "streak tracker" is prominently displayed on-screen, motivating players to beat their previous best streaks.

4. **Difficulty Progression**:
   - As the streak count increases, mini-games become progressively harder:
     - **Quick Math**: Problems involve larger numbers or more complex operations.
     - **Random Targets**: Targets appear faster and require more precision.
     - **Spam Click**: The progress bar requires more clicks to fill.

5. **Self-Contained Gameplay**:
  - Infinite Mini-Games mode is entirely independent of the main tower defense game. No troops, gold, or castle health are involved.
  - The sole objective is to achieve the highest streak possible.

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repository/tower-defense-game.git
   ```
2. **Set Up Your Environment**:
   - Install [JDK 11+](https://www.oracle.com/java/technologies/javase-downloads.html).
   - Use an IDE like IntelliJ IDEA or Eclipse.
3. **Run the Main File**:
   - Execute `MainMenu.java` to start the game.

---

## How to Play

1. Choose a difficulty level from the **Main Menu**.
2. Deploy troops using the **Gameplay Screen**:
   - Earn gold automatically or through mini-games.
   - Select troops based on their strengths and the enemies' weaknesses.
3. Complete **Mini-Games** to gain buffs or avoid penalties.
4. Defend your castle until all waves are defeated or your health runs out.

---

## File Descriptions

### Core Gameplay
- **`gameScreen1.java`**: Manages troop deployments, tower health, and game progression.
- **`AICore.java`**: Controls enemy spawn behavior and difficulty scaling.

### Mini-Games
- **`QuickMath.java`**: Math-based mini-game logic.
- **`RandomTargets.java`**: Target-clicking mini-game logic.
- **`SpamClick.java`**: High-speed clicking mini-game logic.

### Resource Management
- **`GoldCoins.java`**: Handles gold generation and timers.

### Screens
- **`MainMenu.java`**: Game entry point and navigation hub.
- **`pauseScreen.java`**: Pause menu logic.
- **`winScreen.java`**: Displays victory messages.
- **`LoseScreen.java`**: Handles game over conditions.

---

## Future Enhancements

1. **Additional Troops and Enemies**: Introduce more units with unique abilities.
2. **Local Leaderboards**: Compete with players locally.
3. **Customizable Difficulty**: Allow players to tweak specific game settings.
4. **Advanced AI**: Smarter enemy spawn patterns and strategies.

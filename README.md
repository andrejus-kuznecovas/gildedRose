**This is a solution for [GildedRose Refactoring Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata), done with Java programming language. Completed by [Andrej Kuznecov](https://www.linkedin.com/in/andrej-kuznecov-16a3bb143/).** 👋

### **Things Accomplished** 🏆
- Original code has been well covered with Unit tests to make sure functionality works correctly before refactoring starts.
- Original `GildedRose` class code has been removed and replaced with a cleaner solution - each `Item` passed to the method `updateQuality()` gets their own `ItemCase` which calculates changes in their `sellIn/quality` values according to their name.
- After the refactoring, all the tests still pass and new ones were added to check for `Item` quality limits.
- Most of configurable data is stored in `ConfigData` class to keep everything in one place in case of changes.

### **Assumptions Made** 📖
- In the original `GildedRose Refactoring Kata` requirements it is stated, that 
    - The Quality of an item is never negative
    - The Quality of an item is never more than 50

    but the original code allowed `Items` with Quality over 50 or below 0 to be input. 🤔
    
     Assumption was made, that it was and error in original code and `Items` with qualities beyond the limits should have their quality values reset to the nearest limit (example -5 →  0, 90 →  50) after input.
    
    If this assumption is incorrect then some test cases, which check for limit values, might fail with original code.
- It is assumed that `ItemCases` (Categories) cannot stack, for example `Item` with a name of *`Conjured Aged Brie`* will not have both qualities of `Conjured` and of `Aged Brie`. It will be counted to be just a `Conjured` item.
- It is assumed that if an item is `Conjured`, it's name must start with a word *`Conjured`*.
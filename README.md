- Version Control System Notes --

**_ Git _**

- Git is version control tool
- Git is a command-line tool
- Git is software

**_ GitHub _**

- Github is service.
- Github is webApp to store repository.
- GitHub is hosted on the web

**_ Distributed Version Control System _**

\*\* Advantages

- Allows to work offline.
- Entire history of code is at local.
- Doesn't require internet connection all the time.
- merge conflicts are less.

\*\* Disadvantages

- If project is large then it require more time to download
- require more space to store project
- it require push command

**_ Centralized Version Control System _**

\*\* Advantages

- Don't need to clone repo
- Doesn't require push command

\*\* Disadvantages

- Requires internet connection
- single point of failure
- merge conflicts are more

**_ Branch Based Development _**
--- developement is done is seperate branches.There are multiple branches are present for each feature.Once branches merged into main repo then these should be deleted.

\*\* Advantages

- Isolation - each developer work on seperte branches
- Paralled developement
- Singlae main branch
- suitable for large scale projects

\*\* Disadvantages

- Merge conflicts
- integration delay - feature should to complete before merging it.
- complex to manage branch

** Challenges **

- merge conflicts can be time consuming
- over time a large number of branches become difficult to manage

**_ Trunk Based Developement _**
--- Single main branch for developement, there are no other branches are created. Development is done directly on main branch.

\*\* Advantages

- Simple to manage
- suitable for small scale project
- continuous integration
- releases directly from main branch

\*\* Disadvantages

- developer need to be careful to avoid conflicts
- Not suitable for large scale projects

** Challenges **

- Require good communication between the team
- Feature toggle management

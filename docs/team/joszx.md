---
layout: page
title: Seah Zhi Xuan's Project Portfolio Page
---

### Project: SoC InternApply

SoC InternApply - SoC InternApply helps CS students to track internship applications they are interested in. It is optimised for users who prefer CLI and have a lot of company applications and their associated tasks to keep track of. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **Code contributed**: [RepoSense report](https://nus-cs2103-ay2122s2.github.io/tp-dashboard/?search=joszx&breakdown=true)

* **Enhancement to existing feature**: Added the `JobTitle` field to `Application`
  * Internship applications are made to specific job positions hence the need for the `JobTitle` field in `Application`.
  * Added the `JobTitle` class.
  * Modified add and edit command to function for `JobTitle` field.
  * Updated GUI, storage, sample data, relevant test cases and test data to include `JobTitle` field.

* **New Feature**: Implemented the summary bar
  * The summary bar keeps track of relevant statistics such as total number of applications or applications with the `HIGH` priority tag for easy viewing.
  * Added the summarybar folder that houses the summary bar related models such as `SummaryBox` and `SummaryList`.
  * Updated the current commands to update the summary bar on successful execution.
  * Much of the difficulty came from creating the relevant summary bar models from scratch, how they interact, store and fit in the current model architecture as well as creating and integrating the summary bar GUI into our application.

* **Contributions to the UG**:
  * Updated the default UG to SIA.
  * Added the `edit` command.
  * Added in notes for duplicate applications.
  * Fixed format, ordering and typo issues.
  
* **Contributions to the DG**:
  * Fixed format bugs.
  * Added summary bar feature.
  * Worked with the team on user stories.

* **Contributions to team-based tasks**:
  * Monitor TP dashboard progress.
  * Maintaining the issue tracker.
  * Fix general bugs in UG/DG.

* **Reviewing/mentoring contributions**:
  * [PRs reviewed](https://github.com/AY2122S2-CS2103T-T11-3/tp/issues?q=reviewed-by%3Ajoszx)


---
layout: page
title: User Guide
---

SoC InternApply (SIA) is a **desktop app for managing applications, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, SIA can get your contact management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `InternApply.jar` from [here](https://github.com/AY2122S2-CS2103T-T11-3/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your SIA.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/Grab j/Software Engineering Intern e/johnd@example.com` : Adds an application with company named `grab` to SIA.

   * **`delete`**`3` : Deletes the 3rd application shown in the current list.

   * **`clear`** : Deletes all applications.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

<!-- ![help message](images/helpMessage.png) -->

Format: `help`


### Adding an application: `add`

Adds an application to SoC InternApply.

Format: `add <NAME_OF_COMPANY> <JOB_TITLE> <EMAIL> [<STATUS>]`

**Note:** `[<STATUS>]` is optional. For advanced users SoC InternApply.

Examples:
* `add n/Grab j/Software Engineering Intern e/johnd@example.com`
* `add n/Singtel j/UIUX Intern e/betsycrowe@example.com s/Applied`

### Listing all applications : `list`

Shows a list of all applications in SoC InternApply.

Format: `list`

### Deleting a person : `delete`

Deletes the specified application from SoC InternApply.

Format: `delete INDEX`

* Deletes the application at the specified `INDEX`.
* The index refers to the index number shown in the displayed application list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd application.

### Clearing all entries : `clear`

Clears all entries from SoC InternApply.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

InternApply data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

_More features coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous SoC InternApply home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add <NAME_OF_COMPANY> <JOB_TITLE> <EMAIL> [<STATUS>]` <br> e.g., `add n/Singtel j/UIUX Intern e/betsycrowe@example.com s/Applied`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**List** | `list`
**Help** | `help`

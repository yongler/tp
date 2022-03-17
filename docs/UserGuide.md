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

   * **`list`** : Lists all applications.

   * **`add`**`n/Shopee j/Software Engineer Intern p/87438807 e/hr@shopee.sg a/5 Science Park Dr, #06-40 t/SoftwareEngineering` : Adds an application with company named `Shopee` to SIA.
   
   * **``edit``**`1 idt/17-03-2022 16:00` : Update the interview slot to `17 Mar 2022 16:00` for the first application on the list.

   * **`delete`**`3` : Deletes the 3rd application shown in the current list.

   * **`clear`** : Deletes all applications.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/Grab SG`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/Grab SG t/local` or as `n/Grab SG`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/local`, `t/local t/NUS` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![helpMessage](images/helpMessage.png)

Format: `help`

### Adding an application: `add`

Adds an application to SoC InternApply.

Format: `add n/NAME_OF_COMPANY p/PHONE_NUMBER a/ADDRESS j/JOB_TITLE e/EMAIL [t/TAG]... [pt/PRIORITY_TAG] [ast/APPLICATION_STATUS_TAG]`

**Note:** `[t/TAG]`, `[pt/PRIORITY_TAG]` and `[ast/APPLICATION_STATUS_TAG]` are optional. 
* For `[pt/PRIORITY_TAG]`, user input can be any of: `HIGH`, `MEDIUM`, `LOW`
* For `[ast/APPLICATION_STATUS_TAG]`, user input can be any of: `NOT_APPLIED`, `APPLIED`, `INTERVIEWED`, `REJECTED`, `ACCEPTED`
* For the above 2 statements, the inputs are case-insensitive, i.e. `Applied`, `APPLIED` or `applied` are all accepted.
* For `[pt/PRIORITY_TAG]`, only alphanumeric inputs are allowed, i.e. Only the characters A-Z, a-z, 0-9

Examples:
* `add n/Shopee j/Software Engineer Intern p/87438807 e/hr@shopee.sg a/5 Science Park Dr, #06-40 t/SoftwareEngineering `
* `add n/Shopee j/Software Engineer Intern p/87438807 e/hr@shopee.sg a/5 Science Park Dr, #06-40 t/SoftwareEngineering pt/HIGH ast/NOT_APPLIED`

### Listing all applications : `list`

Shows a list of all applications in SoC InternApply.

Format: `list`

### Editing an application : `edit`

Edits an existing application in SoC InternApply.

Format: `edit INDEX [n/NAME] [j/JOB_TITLE] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [idt/INTERVIEW_DATE_TIME] [t/TAG]... \`
- Edits the application at the specified `INDEX`. The index refers to the index number shown in the displayed application list. The index **must be a positive integer** 1, 2, 3, ...
- At least one of the optional fields must be provided.
- Existing values will be updated to the input values.
- You can add an interview slot that includes both date and time by using the `idt/INTERVIEW_DATE_TIME`
- The interview date time, `INTERVIEW_DATE_TIME`, must in the follow format `dd-MM-yyyy HH:mm`.
- You can remove all the application's `TAG`'s by typing `t/` without specifying any tags after it.
- You can remove `INTERVIEW_DATE_TIME` by typing `idt/` without specifying any tags after it.
- When editing `TAG`'s, the existing tags of the application will be removed.

Examples:
- `edit 1 e/SoCStudent@example.com n/NUS Research` Edits the email and name of the 1st application to be `SoCStudent@example.com` and `NUS Research` respectively.
- `edit 2 j/Intern idt/` Edits the job title of the 2nd application to be `Intern` and clears the existing interview date time.

### Deleting an application : `delete`

Deletes the specified application from SoC InternApply.

Format: `delete INDEX`

* Deletes the application at the specified `INDEX`.
* The index refers to the index number shown in the displayed application list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd application.

### Clearing all applications : `clear`

Clears all applications from SoC InternApply.

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
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous SoC InternApply home folder. <br>

**Q**: Why can't I edit the application status and/or priority of an existing application? <br>
**A**: Currently, we do not allow the editing of application status and/or priority. This will be made available in a future version of our application. <br>

**Q**: When I run SoC InternApply for the first time, I do not see any of the sample applications? <br>
**A**: Please locate where InternApply data is being stored on your hard disk. This will usually be in a folder named `data` found in the root folder of the application. Delete any existing files in that folder and run SoC InternApply again. 

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Help** | `help`
    **Add** | `add n/NAME_OF_COMPANY p/PHONE_NUMBER a/ADDRESS j/JOB_TITLE e/EMAIL [t/TAG]... [pt/PRIORITY_TAG] [ast/APPLICATION_STATUS_TAG]` <br> e.g., `add n/Singtel j/UIUX Intern p/62527525 e/singtel@sg.com a/Singtel Group Strategic Communications and Brand, 31 Exeter Road, Comcentre #19-00 ast/APPLIED`
**List** | `list`
**Edit** | `edit INDEX [n/NAME] [j/JOB_TITLE] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [idt/INTERVIEW_DATE_TIME] [t/TAG]... \` <br> e.g, `edit 1 n/Grab SG p/65358292 idt/17-03-2022 13:30`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Clear** | `clear`
**Exit** | `exit`

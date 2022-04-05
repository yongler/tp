---
layout: page
title: User Guide
---

SoC InternApply (SIA) is a **desktop app for managing internship applications, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, SIA can get your internship application management tasks done faster than traditional GUI apps.

With SoC InternApply, you can easily add an application, edit it later on if there are any changes needed, find the applications based on keywords and also sort them based on priority, interview date and much more! All while not having to worry about saving or storing your applications as this is done internally and automatically by SoC InternApply. 

Ultimately, with SoC InternApply, you can worry less about the administrative tasks and focus more on preparing for the interviews themselves!

## Table of Contents
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------
## Glossary
1. SIA (SoC InternApply)

[Go To TOC](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer. You can download it from [this website](https://www.oracle.com/sg/java/technologies/javase/jdk11-archive-downloads.html). 

2. Download the latest `internapply.jar` from [here](https://github.com/AY2122S2-CS2103T-T11-3/tp/releases).

3. Copy the file to the folder you want to use as the _root folder_ for your SIA (e.g. you can save it in your desktop or downloads folder). <br>
**Note:** There will be data (your internship applications) stored into this same folder, but it would not take up much space.

4. Double-click the jar file to start the app. The GUI similar to the diagram below should appear in a few seconds. Note how the app contains some sample data.<br><br>

   ![Ui](images/MainWindowUi.png)

5. Another reminder window should appear automatically similar to the below. Note that this window **would contain any upcoming interviews you have in a weeks time**.<br>
   ![Ui](images/ReminderWindowUi.png)
6. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:
   * **`add`**`n/Shopee j/Software Engineer Intern p/87438807 e/hr@shopee.sg a/5 Science Park Dr, #06-40 t/SoftwareEngineering pt/LOW ast/NOT_APPLIED` : Adds an application with company named `Shopee` to SIA.
   
   * **`clear`** : Deletes all applications.

   * **`delete`**`3` : Deletes the 3rd application shown in the current list.

   * **`edit`** `1 d/Thank you for using SIA!` : Update the details to `Thank you for using SIA!` for the first application on the list.

   * **`edit`**`1 idt/17-03-2022 16:00` : Update the interview slot to `17 Mar 2022 16:00` for the first application on the list.

   * **`exit`** : Exits the app.

   * **`find`**`n/shopee` : Find all applications that contain the word "Shopee" in its name.

   * **`help`** : Shows a message explaining how to access the help page.
    
   * **`list`**`name desc` : Sort all applications base on company name in descending order. 

   * **`reminder`** : Lists all applications with upcoming interviews within a week from now.

7. Refer to the [Features](#features) below for details of each command.

<div markdown="block" class="alert alert-info">

**:information_source: WARNING about modifying local files:**<br>
We are not liable for any data loss, by the user when modifying data stored in the JSON save file.
Edit at your own risk of losing data.


</div>

[Go To TOC](#table-of-contents) 

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/Grab SG`.

* Items in square brackets are optional.<br>
  e.g. `n/NAME [t/TAG]` can be used as `n/Grab SG t/local` or as `n/Grab SG`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/local` or `t/local t/NUS` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `j/Software Engineer j/Data Scientist`, only `j/Data Scientist` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `reminder`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.


**:information_source: Notes about the input format:**<br>

* For `[t/TAG]...`, only alphanumeric inputs are allowed. i.e. Only the characters A-Z, a-z, 0-9.<br> 
  e.g. `t/Based In Singapore` is not allowed, `t/BasedInSingapore` is allowed.

* For `[pt/PRIORITY_TAG]`, user input can only be any one of these: `HIGH`, `MEDIUM`, `LOW`<br>
  e.g `pt/HIGH` can be used to set priority of an application to `HIGH`

* For `[ast/APPLICATION_STATUS_TAG]`, user input can only be any one of these: `NOT_APPLIED`, `APPLIED`, `INTERVIEWED`, `REJECTED`, `ACCEPTED`<br>
  e.g. `ast/INTERVIEWED` can be used to set application status of an application to `INTERVIEWED`

* For `[pt/PRIORITY_TAG]` and `[ast/APPLICATION_STATUS_TAG]`, the inputs are case-insensitive<br>
  e.g. `pt/HIGH` can be inputted with `pt/high` and `ast/INTERVIEWD` can be inputted with `ast/Interviewed`

* For `[j/JobTitle]...`, only alphanumeric inputs are allowed. i.e. Only the characters A-Z, a-z, 0-9. Spaces are also allowed. <br> 
  e.g. `j/SoftwareEngineerIntern` is allowed, `t/Software Engineer Intern` is also allowed.



</div>

[Go To TOC](#table-of-contents)

### Adding an application: `add`

Adds an application to SoC InternApply.

**Format:** `add n/NAME_OF_COMPANY j/JOB_TITLE p/PHONE_NUMBER a/ADDRESS e/EMAIL [t/TAG]... [pt/PRIORITY_TAG] [ast/APPLICATION_STATUS_TAG]`

**Note:** `NAME_OF_COMPANY` has to be unique. <br>
**Note:** `[t/TAG]`, `[pt/PRIORITY_TAG]` and `[ast/APPLICATION_STATUS_TAG]` are optional.

**Example usages and expected outcomes:**
* `add n/Shopee j/Software Engineer Intern p/87438807 e/hr@shopee.sg a/5 Science Park Dr, #06-40 t/SoftwareEngineering `

Feedback message:

```
New application added: Shopee; Job Title: Software Engineer Intern; 
Phone: 87438807; Email: hr@shopee.sg; Address: 5 Science Park Dr, #06-40; 
Interview Slot: Interview date is not set.; Details: To add details, use the edit command; 
Tags: SoftwareEngineering
```

* `add n/Shopee j/Software Engineer Intern p/87438807 e/hr@shopee.sg a/5 Science Park Dr, #06-40 t/SoftwareEngineering pt/HIGH ast/NOT_APPLIED`

Feedback message:
```
This application already exists in InternApply
```

[Go To TOC](#table-of-contents)

### Clearing all applications: `clear`

Clears all applications from SoC InternApply.

**Format:** `clear`

[Go To TOC](#table-of-contents)

### Deleting an application: `delete`

Deletes the specified application from SoC InternApply.

**Format:** `delete INDEX`

* Deletes the application at the specified `INDEX`.
* The index refers to the index number shown in the displayed application list.
* The index **must be a positive integer** 1, 2, 3, …​

**Example usages:**
* `list` followed by `delete 2` deletes the 2nd application.

**Expected outcome:**

The previous 2nd application is removed from the storage and a new list of applications is shown.

[Go To TOC](#table-of-contents)

### Editing an application: `edit`

Edits an existing application in SoC InternApply.

**Format:** `edit INDEX [n/NAME] [j/JOB_TITLE] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [idt/INTERVIEW_DATE_TIME] [d/DETAILS] [t/TAG]... [pt/PRIORITY_TAG] [ast/APPLICATION_STATUS_TAG]`

**CAUTION:** The `edit` command might overwrite your existing application data.
<br>
- Edits the application at the specified `INDEX`. The index refers to the index number shown in the displayed application list. The index **must be a positive integer** 1, 2, 3, ...
- At least one of the optional fields must be provided.
- Existing values will be updated to the input values.
- You can add an interview slot that includes both date and time by using the `idt/INTERVIEW_DATE_TIME`
- The interview date time, `INTERVIEW_DATE_TIME`, must be in the follow format `dd-MM-yyyy HH:mm`.
- You can remove `INTERVIEW_DATE_TIME` by typing `idt/` without specifying any tags after it.
- - You can add details to the application by using `d/DETAILS`
- You can enter new lines in the details by using `\n`
- You  can remove `DETAILS` by typing `d/` without any strings following it, which will revert the field back to the default of `To add details, use the edit command`
- When editing the `TAG` field, if `t/` is given without any input general tags will be removed

**Example usages and expected outcomes:**
- `edit 1 e/SoCStudent@example.com n/NUS Research` Edits the email and name of the 1st application to be `SoCStudent@example.com` and `NUS Research` respectively.
- `edit 1 t/Singapore ast/APPLIED` Edits the tags and application status tag of the 1st application to Singapore and APPLIED respectively. Since the priority tag is not specified, the 1st application will keep its current priority tag if it had any.
- `edit 2 j/Intern idt/` Edits the job title of the 2nd application to be `Intern` and clears the existing interview date time.

- To edit the details of an application, you can follow this format (adding \n to type in a new line): `edit 1 d/Example details \nThis is a newline of the details`

e.g.`edit 1 d/This company requires a preliminary coding round.\n I should practice more on HackerRank` will result in this details being added:

```
This company requires a preliminary coding round. 
I should practice more on HackerRank
```

[Go To TOC](#table-of-contents)

### Exiting the program: `exit`

Exits the program.

**Format:** `exit`

[Go To TOC](#table-of-contents)

### Finding application(s): `find`

Finds existing applications in SoC InternApply.

**Format:** `find [n/NAME] or find [j/JOB_TITLE] or find [t/TAG]... or find [pt/PRIORITY_TAG] or find [ast/APPLICATION_STATUS_TAG]`
- Finds the applications with the fields containing keywords given in the input.
- Keywords are case-insensitive.
- Parameters are only expected once (except tags). e.g. `find n/shopee n/grab` is equivalent to `find n/grab`, the last occurrence of the parameter will be taken.
- If more than 1 different fields are given, i.e. `find n/shopee j/ML`, only the first field will be processed, i.e. `find n/shopee j/ML` is the same as `find n/shopee`

**Example usages and expected outcomes:**
- `find n/shopee` finds and displays all applications with "Shopee" in its name.
- `find j/ML` finds and displays all applications with "ML" in its job title.
- `find pt/HIGH` finds and displays all applications with "HIGH" in its priority tag.
- `find ast/applied` finds and displays all applications with "applied" in its application status. (note that it is case-insensitive)
- `find t/overseas` finds and displays all applications with "overseas" in its tags.
- `find t/overseas t/USA` finds and displays all applications with "overseas" or "USA" in its tags.

[Go To TOC](#table-of-contents)

### Viewing help: `help`

This command displays a message explaining how to access the help page. 

**Format:** `help`

**Example usages:** 

`help`

**Expected outcome:**

A popup window showing a link to the help page, as shown below.
![helpMessage](images/helpMessage.png)

[Go To TOC](#table-of-contents)

### Listing all applications in a sorted manner: `list`

Sorts the list of all application in SoC InternApply base on the provided parameters.

**Format:** `list [sorting paramter] [order by]`

Sorting parameters: 
- `name` : Sort by name of the company in alphabetical order starting with A in ascending order.
- `interview` : Sort by interview date of applications starting with the latest earliest date.
- `priority` : Sort by priority in the following order - HIGH, MEDIUM, LOW.
- `status` : Sort by status in the following order - ACCEPTED, REJECTED, INTERVIEWED, APPLIED and NOT_APPLIED.

* If optional fields (i.e. interview date and time, priority, status) do not exist in that certain application, that application will be moved to the bottom of the sorting order. If there is more than one of such application, it will be sorted alphabetically.

Order by:
- `asc` : Order by ascending.
- `desc` : Order by descending (reverse order of ascending).

Examples:
* `list interview desc`
* `list name desc`, running this will output:
<br>
```
Sorted applications by name order by desc.
```

> 💡 The `list` command also works without parameters. It will be reverted to the last sorted parameter and order used by the user. This is used after using the `find` feature to list out all applications. 

> ⚠️ Applications are originally sorted in  a chronological order base on create date and time. Do take note that after using the `list` feature to sort, you will not be able to sort the applications in chronological order.

> ❗ Sorting will not apply to newly added or newly edited applications. Please re-run the `list` command with the respective parameters to sort as per you like.


[Go To TOC](#table-of-contents)

### Listing applications with upcoming interviews: `reminder`

Shows a list of applications with upcoming interviews, falling within a week from now, in SoC InternApply.

**Format:** `reminder`

**Example usages:**

`reminder`

**Expected outcome:**

A new window pops up, showing a list of applications with upcoming interviews within a week from now.

[Go To TOC](#table-of-contents)

### Saving the data

InternApply data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

[Go To TOC](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## FAQ
**Q**: How do I know where my internship applications data is stored?<br>
**A**: Please locate where SoC InternApply is being stored on your computer. You will see a folder named `data` found in the root folder of the application (the folder containing SoC InternApply) Inside the `data` folder, you can find a data file named `internapplymemory.json`, which stores all the applications.

**Q**: How do I transfer my data to another computer?<br>
**A**: Refer to the 1st QnA to locate the data file. Install the app in the other computer. Copy the contents of the data file of SoC InternApply from your previous computer and paste it in the empty data file of SoC InternApply of the new computer. <br>

**Q**: When I run SIA for the first time, I do not see any of the sample application. How can I get the sample applications to appear in SIA? <br>
**A**: Refer to the 1st QnA to locate the `data` folder. Delete any existing files in the `data` folder and run SoC InternApply again.


[Go To TOC](#table-of-contents)

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
[**Add**](#adding-an-application-add) | `add n/NAME_OF_COMPANY p/PHONE_NUMBER a/ADDRESS j/JOB_TITLE e/EMAIL [t/TAG]... [pt/PRIORITY_TAG] [ast/APPLICATION_STATUS_TAG]` <br><br>  e.g., `add n/Singtel j/UIUX Intern p/62527525 e/singtel@sg.com a/Singtel Group Strategic Communications and Brand, 31 Exeter Road, Comcentre #19-00 ast/APPLIED`
[**Clear**](#clearing-all-applications-clear) | `clear`
[**Delete**](#deleting-an-application-delete) | `delete INDEX`<br> <br> e.g., `delete 3`
[**Edit**](#editing-an-application-edit) | `edit INDEX [n/NAME] [j/JOB_TITLE] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [idt/INTERVIEW_DATE_TIME] [t/TAG]... [pt/PRIORITY_TAG] [ast/APPLICATION_STATUS_TAG]` <br> <br> e.g, `edit 1 n/Grab SG p/65358292 idt/17-03-2022 13:30`
[**Exit**](#exiting-the-program-exit) | `exit`
[**Find**](#finding-applications-find) | `find [n/NAME] or find [j/JOB_TITLE] or find [t/TAG]... or find [pt/PRIORITY_TAG] or find [ast/APPLICATION_STATUS_TAG]`<br> <br> e.g., `find n/shopee`
[**Help**](#viewing-help-help) | `help`
[**List**](#listing-all-applications-in-a-sorted-manner-list) | `list [sorting paramter] [order by]`
[**Reminder**](#listing-applications-with-upcoming-interviews-reminder)| `reminder`


[Go To TOC](#table-of-contents)

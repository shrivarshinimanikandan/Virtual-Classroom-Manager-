import java.util.*;
public class VirtualClassroomManager {
private static final Scanner scanner = new Scanner(System.in);
private static final Map&lt;String, Set&lt;String&gt;&gt; classrooms = new HashMap&lt;&gt;();
private static final Map&lt;String, Set&lt;String&gt;&gt; assignments = new HashMap&lt;&gt;();
private static final Map&lt;String, Set&lt;String&gt;&gt; submissions = new HashMap&lt;&gt;();
public static void main(String[] args) {
while (true) {
System.out.println(&quot;Enter a command:&quot;);
String command = scanner.nextLine();
handleCommand(command);
}
}
private static void handleCommand(String command) {
String[] parts = command.split(&quot; &quot;, 3);
String action = parts[0];
switch (action) {
case &quot;add_classroom&quot;:
if (parts.length &lt; 2) {
System.out.println(&quot;Invalid command. Usage: add_classroom [Class Name]&quot;);
break;
}
addClassroom(parts[1]);
break;
case &quot;add_student&quot;:
if (parts.length &lt; 3) {
System.out.println(&quot;Invalid command. Usage: add_student [Student ID] [Class
Name]&quot;);
break;
}
addStudent(parts[1], parts[2]);
break;
case &quot;schedule_assignment&quot;:
if (parts.length &lt; 3) {
System.out.println(&quot;Invalid command. Usage: schedule_assignment [Class
Name] [Assignment Details]&quot;);
break;
}
scheduleAssignment(parts[1], parts[2]);
break;
case &quot;submit_assignment&quot;:
if (parts.length &lt; 3) {

System.out.println(&quot;Invalid command. Usage: submit_assignment [Student ID]
[Class Name] [Assignment Details]&quot;);
break;
}
submitAssignment(parts[1], parts[2], parts[3]);
break;
default:
System.out.println(&quot;Unknown command.&quot;);
break;
}
}
private static void addClassroom(String className) {
if (classrooms.containsKey(className)) {
System.out.println(&quot;Classroom already exists.&quot;);
return;
}
classrooms.put(className, new HashSet&lt;&gt;());
assignments.put(className, new HashSet&lt;&gt;());
submissions.put(className, new HashSet&lt;&gt;());
System.out.println(&quot;Classroom &quot; + className + &quot; has been created.&quot;);
}
private static void addStudent(String studentId, String className) {
if (!classrooms.containsKey(className)) {
System.out.println(&quot;Classroom does not exist.&quot;);
return;
}
classrooms.get(className).add(studentId);
System.out.println(&quot;Student &quot; + studentId + &quot; has been enrolled in &quot; + className + &quot;.&quot;);
}
private static void scheduleAssignment(String className, String assignmentDetails) {
if (!classrooms.containsKey(className)) {
System.out.println(&quot;Classroom does not exist.&quot;);
return;
}
assignments.get(className).add(assignmentDetails);
System.out.println(&quot;Assignment for &quot; + className + &quot; has been scheduled.&quot;);
}
private static void submitAssignment(String studentId, String className, String
assignmentDetails) {
if (!classrooms.containsKey(className)) {
System.out.println(&quot;Classroom does not exist.&quot;);
return;
}
if (!classrooms.get(className).contains(studentId)) {

System.out.println(&quot;Student not enrolled in this class.&quot;);
return;
}
submissions.get(className).add(studentId + &quot;: &quot; + assignmentDetails);
System.out.println(&quot;Assignment submitted by Student &quot; + studentId + &quot; in &quot; + className
+ &quot;.&quot;);
}
}

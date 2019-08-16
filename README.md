Hybrid Framework:
The Purpose of This Framework is to showcase the End to End flow for Web  Applications and Continuous Testing using Jenkins.
Description:
This framework is very easy to understand. This implements the Cucumber(BDD), ModularDriven Technique, Log4j Logging, Extent Reporting & Junit Reports & Cucumber Reports.
Getting Started :
Dependencies:
We need The Following Dependencies to Work With Hybrid Framework,
<dependencies>
<dependency>
?	<groupId>junit</groupId>
?	<artifactId>junit</artifactId>
?	<groupId>info.cukes</groupId>
?	<artifactId>cucumber-junit</artifactId>
?	<groupId>info.cukes</groupId>
?	<artifactId>cucumber-java</artifactId>
?	<groupId>info.cukes</groupId>
?	<artifactId>cucumber-core</artifactId>
o	<groupId>org.seleniumhq.selenium</groupId>
o	<artifactId>selenium-java</artifactId>
</dependency>
</dependencies>

?	Also We Cucumber Plugin to Integrate with Project to Write Feature Files.
Installing :
?	First of all Download The Project From ,
 https://github.com/daisymani/Hybrid-Framework.git
?	After Downloading the Project , Import the code in any Existing IDE Environment as Existing Maven Project .

Executing program:

?	Below I have My Runner Class (JunitRunner), From this I will run My Entire Project  Run as ? Junittest 
 

?	If You want run as Maven Project, try these Following Commands in Command Prompt.
--mvn test (Running as Maven Test)
--mvn clean test (Running as Maven Clean Test)
--mvn –Dtest=JunitRunner (Running as Maven Test From Runner File)

Authors:
1.)Koushick Sudharsanam
2.) Mohankumar Arumugam
3.) Nagaraj 


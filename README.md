# Prerequisite
1. JAVA 11 or above
2. Maven 3 or above
3. Ngrok (if running from local)


# Test Locally
1. Checkout the code.
2. Execute spring-boot
<code>mvn clean spring-boot:run</code>
3.Expose publically with ngrok <code>./ngrok http 8080</code>
4.Copy ngrok url and append /filter endpoint i.e. <code>http://3734f70346a1.ngrok.io/filter</code>
5.Test on <code>http://resumes.brealtime.com/</code>
6.Submit

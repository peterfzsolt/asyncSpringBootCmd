# Spring Boot Command line application with Enable async

A small Spring boot application wihtout web environment and async configuration enabled. 


Even if the marked as correct answer is valid. This is not full answer.

Without @EnableAsync and without WEB environment .web(WebApplicationType.NONE) the spring boot app automatically stop once started(as there is nothing to do/wait). So even if you don't do apringApp.close() in your app but only app.run(commandLine), the .close() method call automatically.

But once you added @EnableAsync - the behavior changes, as there might be async work, so app is not stopped once started. And if there is not stopping code, the app remain working (hangs).

For fixing this you need to do 2 things:

    - in the run method do wait all async work
    - implicitly call .close() after app started

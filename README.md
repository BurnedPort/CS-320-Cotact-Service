# CS-320-Cotact-Service
Software Test Automation &amp; QA

How can I ensure that my code, program, or software is functional and secure?
I ensure functionality by writing unit tests that cover both normal behavior and edge cases, then using test results to catch defects early. I also validate inputs, enforce constraints (like required field lengths and non-null rules), and design code so it fails safely when invalid data is provided. For security, I follow defensive coding practices (input validation, least privilege mindset, and avoiding risky assumptions), and I treat tests as a way to prevent regressions that could reintroduce security or reliability issues over time.

How do I interpret user needs and incorporate them into a program?
I start by translating requirements into concrete rules the software must enforce (for example, required fields, maximum lengths, allowed formats, and error handling). From there, I build features around those rules and create tests that directly map to the requirements, so I can prove the program meets them. If something is unclear, I treat it as a risk and design for predictability: clear constraints, clear exceptions, and behavior that matches what the user would expect.

How do I approach designing software?
I focus on clean structure and maintainability first: small classes with single responsibilities, clear method names, and consistent validation rules. I also separate data models from services so the code is easier to test and extend. I design with testing in mind (testable methods, minimal side effects), and I refactor when tests reveal duplication or weak spots in the design.

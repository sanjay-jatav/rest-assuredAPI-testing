
---

## 🔧 Technologies Used

- Java
- [Rest Assured](https://rest-assured.io/)
- TestNG
- Maven
- JSONPlaceholder Fake API

---

## 🧪 Test Cases in `RAEvaluation.java`

| Test Method                    | Description                                                                |
|--------------------------------|----------------------------------------------------------------------------|
| `statusCode()`                 | Validates status code and body of GET request for post ID 1.               |
| `postRequest()`                | Sends a POST request and verifies the response body and status code.       |
| `testUpdatePost()`             | Updates an existing post using PUT method.                                 |
| `testPartialUpdateTitle()`     | Partially updates the post's title using PATCH method.                     |
| `testDeletewithVerification()` | Verifies the post exists, deletes it, and re-verifies status.              |

---

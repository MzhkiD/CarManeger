_ Route Naming
func main() {
app := fiber.New()
// GET /api/register
app Get ("/api/*™, func(c *fiber. Ct₽) enror,))
msg := fmt.Sprintf(" %s"
return c.SendString(msg) // => & register
} ) . Name("api")
data, _ := json.MarshalIndent (app.GetRoute("api"), "'*, " ")
fmt.Print(string(data))
// Prints:
// €
//
//
//
//
//
"method": "GET",
"name": "api",
"path": "/api/*",
"params": [
"*1"
//
// }
1og-Fatal(app. Listen(":3000"))
}

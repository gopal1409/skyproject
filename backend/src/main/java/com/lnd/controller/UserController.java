@GetMapping("/search")
public String searchUser(@RequestParam String username) {

    String query = "SELECT * FROM users WHERE username = ?";

    return jdbcTemplate.queryForObject(query, new Object[]{username}, String.class);
}
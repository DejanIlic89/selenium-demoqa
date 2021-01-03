Feature: ToolsQA - Student Registration Form Page

  @dev
  Scenario Outline: Student should be able to submit Registration Form
    Given I am on Student registration form
    When I enter first name as "<firstName>"
    And I enter last name as "<lastName>"
    And I enter email as "<email>"
    And I enter gender as "<gender>"
    And I enter mobile as "<mobile>"
    And I enter date of birth as "<dateOfBirth>"
    And I enter subjects as "<subjects>"
    And I enter hobbies as "<hobbies>"
    And I enter picture as "<picture>"
    And I enter current address as "<currentAddress>"
    And I enter state as "<state>"
    And I enter city as "<city>"
    And I submit student registration form
    Then I should see Student Confirmation Modal is displayed

    Examples:
      | firstName | lastName | email             | gender | mobile     | dateOfBirth   | subjects      | hobbies       | picture     | currentAddress  | state | city  |
      | Dejan     | Ilic     | theekey@gmail.com | Male   | 0691234567 | 27 April 1989 | Arts, Physics | Sports, Music | student.png | London Street 6 | NCR   | Delhi |
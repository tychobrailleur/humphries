#
# User steps.
#


Given /^I am logged in as (.*)$/ do |role|
  visit 'http://localhost:8080/humphries/login/auth'
  fill_in 'username', :with => 'pierre'
  fill_in 'password', :with => 'password'
  click_button 'Login'
end

Given /^I am on the home page$/ do 
  visit 'http://localhost:8080/humphries'
end

When /^I authenticate as "([^"]+)"$/ do |username|
  click_link 'Login'
  fill_in 'username', :with => username
  fill_in 'password', :with => 'password'
  click_button 'Login'
end

When /^I sign out$/ do
  visit 'http://localhost:8080/humphries/logout'
end

Then /^I should see I am logged in as "([^"]+)"$/ do |username|
  visit 'http://localhost:8080/humphries'
  response.should contain("Hiya, #{username}")
  response.should contain("Sign out")
  response.should_not contain("Login")
end

Then /^I should see I am not logged in as "([^"]+)"$/ do |username|
  visit 'http://localhost:8080/humphries'
  response.should_not contain("Hiya, #{username}")
  response.should_not contain("Sign out")
  response.should contain("Login")
end



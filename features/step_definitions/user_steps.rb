Given /^I am logged in as (.*)$/ do |role|
  visit 'http://localhost:8080/humphries/login/auth'
  fill_in 'username', :with => 'pierre'
  fill_in 'password', :with => 'password'
  click_button 'Login'
end


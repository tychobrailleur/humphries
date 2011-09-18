When /^I create a project "([^"]+)" with code "([^"]+)"$/ do |name, code|
  visit 'http://localhost:8080/humphries/project/list'
  click_link 'New Project'
  fill_in 'name', :with => name
  fill_in 'code', :with => code
  fill_in 'description', :with => 'Lorém Ipsûm dœlor s€€t am¥t'
  click_button 'Create'
end

Then /^"([^"]+)" should be in the project list$/ do |project|
  visit 'http://localhost:8080/humphries/project/list'
  response.should contain(project)
end
